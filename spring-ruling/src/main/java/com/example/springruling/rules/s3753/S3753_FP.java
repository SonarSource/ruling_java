package com.example.springruling.rules.s3753;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * S3753 - False Positive: Controller that delegates setComplete to a helper service.
 *
 * The setComplete() call happens inside a helper method called by the controller.
 * The analyzer may not follow the delegation and still flag this controller as
 * missing the setComplete() call, even though it does happen via the helper.
 */
@Controller
@SessionAttributes("user") // setComplete() is called via helper - analyzer may not follow
public class S3753_FP {

    @GetMapping("/s3753/fp/user")
    public String showUser(Model model) {
        model.addAttribute("user", new UserModel("Carol"));
        return "user";
    }

    @PostMapping("/s3753/fp/user/submit")
    public String submitUser(SessionStatus status) {
        cleanupSession(status); // Delegation to helper
        return "redirect:/s3753/fp/user";
    }

    /**
     * Helper that performs session cleanup. The analyzer may not trace into this
     * method to find the setComplete() call.
     */
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
