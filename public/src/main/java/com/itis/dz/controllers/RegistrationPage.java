package com.itis.dz.controllers;

import com.itis.dz.HashMake;
import com.itis.dz.forms.RegistrationFormBean;
import com.itis.dz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/reg")
public class RegistrationPage extends BaseController {

    @Autowired
    private UserService userService;

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
        return "registration/registrationPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean registrationFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !userService.checkUser(registrationFormBean.getEmail()) ||
                !registrationFormBean.getPassword().equals(registrationFormBean.getConfirmPassword())) {
            request.setAttribute("contains", true);
            return "registration/registrationPage";
        }
        HashMake hashMake = new HashMake();
        userService.addUser(registrationFormBean.getName(), registrationFormBean.getEmail(), hashMake.md5Apache(registrationFormBean.getPassword()));
        request.setAttribute("contains", null);
        return "registration/result";
    }
}
