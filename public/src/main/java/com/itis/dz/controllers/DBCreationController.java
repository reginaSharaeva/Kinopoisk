package com.itis.dz.controllers;


import com.itis.dz.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DBCreationController extends BaseController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @Autowired
    private AwardService awardService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/createDB")
    public String createDB(){
        userService.addTestData();
        awardService.addTestData();
        countryService.addTestData();
        genreService.addTestData();
        roleService.addTestData();
        personService.addTestData();
        movieService.addTestData();


        return "redirect:/";
    }
}
