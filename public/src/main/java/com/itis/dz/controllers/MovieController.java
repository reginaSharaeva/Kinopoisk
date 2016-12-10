package com.itis.dz.controllers;

import com.itis.dz.entities.Comment;
import com.itis.dz.entities.User;
import com.itis.dz.security.AuthorizedUsersInfo;
import com.itis.dz.services.CommentService;
import com.itis.dz.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;


@Controller
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MovieService movieService;
    @Autowired
    private CommentService commentService;


    @RequestMapping(method = RequestMethod.GET)
    public String renderMovieView() {
        return "catalog/catalog";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderMoviePage(@PathVariable("id") Long id) {
        request.setAttribute("movie", movieService.getMovieById(id));
        request.setAttribute("comments_count", movieService.getMovieById(id).getComments().size());
        return "/movie/moviePage";
    }
    /**
     * Добавление комментария
     */
    @ResponseBody
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addComment(Long filmId) {
        User user = null;
        if (AuthorizedUsersInfo.isLoggedIn()) {
            user = AuthorizedUsersInfo.getCurrentUser();
        }
        System.out.println(request.getParameter("text"));
        if (user != null) {
            Comment comment=new Comment(request.getParameter("text"), Calendar.getInstance(),user,
                    movieService.getMovieById(filmId));
            System.out.println("coomennr: "+comment);
            commentService.addComment(comment);
            request.setAttribute("comment",comment);
        }
        return "/movie/comment";
    }
}
