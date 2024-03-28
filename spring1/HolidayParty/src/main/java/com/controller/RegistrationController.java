package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.model.RegistrationBean;
import com.validate.CustomValidator;

@Controller
public class RegistrationController {

    @Autowired
    private CustomValidator custValidator;

    @GetMapping("/registerPage")
    public String registerPage(ModelMap model) {
        model.addAttribute("registrationBean", new RegistrationBean());
        return "registrationpage";
    }

    @PostMapping("/performRegistration")
    public ModelAndView performRegistration(@ModelAttribute("registrationBean") RegistrationBean registrationBean,
            BindingResult result) {
        custValidator.validate(registrationBean, result);

        if (result.hasErrors()) {
            return new ModelAndView("registrationpage");
        } else {
            // Redirect to thankyou.jsp
            ModelAndView modelAndView = new ModelAndView("thankyou");
            modelAndView.addObject("userName", registrationBean.getUserName());
            modelAndView.addObject("emailId", registrationBean.getEmailId());
            return modelAndView;
        }
    }
}
