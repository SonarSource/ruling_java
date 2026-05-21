package com.example.springruling.rules.s3753;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * S3753 - True Negative: @Controller with @SessionAttributes and setComplete() call.
 *
 * This controller properly calls status.setComplete() in the submit handler to
 * clean up session attributes after the form workflow is done.
 * SonarJava should NOT flag this.
 */
@Controller
@SessionAttributes("user") // Compliant - setComplete() is called below
public class S3753_TN {

    @GetMapping("/s3753/tn/user")
    public String showUser(Model model) {
        model.addAttribute("user", new UserModel("Bob"));
        return "user";
    }

    @PostMapping("/s3753/tn/user/submit")
    public String submitUser(SessionStatus status) {
        status.setComplete(); // Properly cleans up session attributes
        return "redirect:/s3753/tn/user";
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
