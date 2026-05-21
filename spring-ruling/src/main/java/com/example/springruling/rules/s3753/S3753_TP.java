package com.example.springruling.rules.s3753;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * S3753 - True Positive: @Controller with @SessionAttributes but no setComplete() call.
 *
 * When a controller uses @SessionAttributes, it stores model attributes in the
 * HTTP session. The controller must call SessionStatus.setComplete() at some
 * point to clean up those session attributes. Without it, session data leaks.
 * SonarJava should flag this as a violation of S3753.
 */
@Controller
@SessionAttributes("user") // Noncompliant - no setComplete() call anywhere in this controller
public class S3753_TP {

    @GetMapping("/s3753/tp/user")
    public String showUser(Model model) {
        model.addAttribute("user", new UserModel("Alice"));
        return "user";
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
