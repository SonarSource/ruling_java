package com.example.springruling.rules.s3753;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * S3753 - False Negative: setComplete() only called in a private method that is
 * never invoked from a handler method.
 *
 * The controller has setComplete() in a private method, but that method is never
 * called by any public handler. The analyzer may see setComplete() exists in the
 * class and consider the rule satisfied, but the cleanup never actually happens
 * at runtime because the method is unreachable from any request handler.
 */
@Controller
@SessionAttributes("user") // setComplete() exists but is never reachable from a handler
public class S3753_FN {

    @GetMapping("/s3753/fn/user")
    public String showUser(Model model) {
        model.addAttribute("user", new UserModel("Dave"));
        return "user";
    }

    @PostMapping("/s3753/fn/user/submit")
    public String submitUser() {
        // Does NOT call cleanupSession() - the session is never cleaned up
        return "redirect:/s3753/fn/user";
    }

    /**
     * This private method calls setComplete(), but it is never invoked by any
     * handler method. The analyzer may still detect it and consider the rule
     * satisfied, resulting in a false negative.
     */
    @SuppressWarnings("unused")
    private void cleanupSession(SessionStatus status) {
        status.setComplete();
    }

    /** Simple model class used for session attributes. */
    static class UserModel {
        private String name;

        UserModel(String name) {
            this.name = name;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}
