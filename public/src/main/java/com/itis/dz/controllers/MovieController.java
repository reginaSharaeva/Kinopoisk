package com.itis.dz.controllers;

import com.itis.dz.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderMovieView() {
        return "catalog/catalog";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderMoviePage(@PathVariable("id") Long id) {
        request.setAttribute("movie", movieService.getMovieById(id));

        return "/movie/moviePage";
    }

}
