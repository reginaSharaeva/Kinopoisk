package com.itis.dz.controllers;

import com.itis.dz.HashMake;
import com.itis.dz.entities.User;
import com.itis.dz.forms.ChangeUserInfoFormBean;
import com.itis.dz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/change")
public class ChangeUserInfoController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    private static final String ATTR_CHANGE_FORM = "changeForm";

    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        ChangeUserInfoFormBean changeInfoFormBean = new ChangeUserInfoFormBean();
        changeInfoFormBean.setName(user.getName());
        changeInfoFormBean.setPassword(user.getHash_pass());
        changeInfoFormBean.setConfirmPassword(user.getHash_pass());
        request.setAttribute(ATTR_CHANGE_FORM, changeInfoFormBean);
        return "cabinet/changeInfo";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeInfo(@Valid @ModelAttribute(ATTR_CHANGE_FORM) ChangeUserInfoFormBean changeInfoFormBean,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !changeInfoFormBean.getPassword().equals(changeInfoFormBean.getConfirmPassword())) {
            request.setAttribute("incorrect", true);
            return "cabinet/changeInfo";
        }
        User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        user.setName(changeInfoFormBean.getName());
        if (changeInfoFormBean.getPassword() != null) {
            HashMake hashMake = new HashMake();
            user.setHash_pass(hashMake.md5Apache(changeInfoFormBean.getPassword()));
        }
        request.setAttribute("currentUser", user);
        return "cabinet/cabinet";
    }
}

