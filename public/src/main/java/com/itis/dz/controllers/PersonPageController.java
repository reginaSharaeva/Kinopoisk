package com.itis.dz.controllers;

import com.itis.dz.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/person")
public class PersonPageController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderPersonView() {
        return "catalog/catalog";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderPersonPage(@PathVariable("id") Long id) {
        request.setAttribute("person", personService.getPersonById(id));
        return "person/personInfo";
    }
}
