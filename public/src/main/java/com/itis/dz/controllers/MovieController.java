package com.itis.dz.controllers;

import com.itis.dz.elastic.IMovieSearchService;
import com.itis.dz.entities.Comment;
import com.itis.dz.entities.Genre;
import com.itis.dz.entities.Movie;
import com.itis.dz.entities.User;
import com.itis.dz.security.AuthorizedUsersInfo;
import com.itis.dz.services.CommentService;
import com.itis.dz.services.GenreService;
import com.itis.dz.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;


@Controller
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MovieService movieService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private IMovieSearchService movieSearchService;

    @Autowired
    private GenreService genreService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderMoviePage(@PathVariable("id") Long id) {
        request.setAttribute("movie", movieService.getMovieById(id));
        System.out.println(movieService.getMovieById(id));
        System.out.println(movieService.getMovieById(id).getComments().size());
        request.setAttribute("comments_count", movieService.getMovieById(id).getComments().size());
        return "/movie/moviePage";
    }
    /**
     * Добавление комментария
     */
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addComment(Long filmId, String text) {
         User user = null;
        if (AuthorizedUsersInfo.isLoggedIn()) {
            user = AuthorizedUsersInfo.getCurrentUser();
        }
        if (user != null) {
            Comment comment=new Comment(text, Calendar.getInstance(),user,
                    movieService.getMovieById(filmId));
            commentService.addComment(comment);
            request.setAttribute("comment",comment);
        }
        return "/movie/comment";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddingMovieView() {
        return "movie/newMovie";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<List<Movie>> searchByName(@RequestParam(required = false) String name) {

        List<Movie> movies = new ArrayList<>();

        //values.add("приключения");
        if (!name.isEmpty()) {
            movies = movieSearchService.matchNameQuery(name);

            //  System.out.println(movies.size());
        }
        if (movies.isEmpty()) {
            movies = movieSearchService.findAll();
        }


        return ResponseEntity.ok(movies);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/autocomplete")
    public ResponseEntity<String> searchAuto(@RequestParam String q) {
        return ResponseEntity.ok(movieSearchService.autocomplete(q));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/filter")
    public ResponseEntity<List<Movie>> filter(@RequestParam(required = false) String genres, String from, String before) {
        List<String> genresList = new ArrayList<>();
        if (!genres.isEmpty()) {
            StringTokenizer tokenizer = new StringTokenizer(genres + ",");
            while (tokenizer.hasMoreTokens()) {
                genresList.add(tokenizer.nextToken(","));
            }
        }
        List<Movie> genreArrayList = new ArrayList<>();

        if (!genresList.isEmpty() && !from.isEmpty() && !before.isEmpty()) {
            genreArrayList = movieSearchService.fullFilterQuery(genresList, from, before);

        } else if (genresList.isEmpty() && !from.isEmpty() && !before.isEmpty()) {

            genreArrayList = movieSearchService.rangeYearFilterQuery(from, before);
        } else if (!genresList.isEmpty() && from.isEmpty() && before.isEmpty()) {
            genreArrayList = movieSearchService.genresFilterQuery(genresList);

        } else if (genresList.isEmpty() && (from.isEmpty() ^ before.isEmpty())) {
            if (from.isEmpty()) {
                genreArrayList = movieSearchService.yearFilterQuery(before);
            } else genreArrayList = movieSearchService.yearFilterQuery(from);

        } else if (!genresList.isEmpty() && (from.isEmpty() ^ before.isEmpty())) {
            if (from.isEmpty()) {
                genreArrayList = movieSearchService.genresYearFilterQuery(genresList, before);
            } else genreArrayList = movieSearchService.genresYearFilterQuery(genresList, from);
        }

        if (genreArrayList.isEmpty()) {
            genreArrayList = movieSearchService.findAll();
        }
        return ResponseEntity.ok(genreArrayList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/genresFromFilter")
    public ResponseEntity<List<String>> genresFromFilter() {
        List<Genre> genres = genreService.getGenres();
        ArrayList<String> genres1 = new ArrayList<>();
        for (int i = 0; i < genres.size(); i++) {
            genres1.add(genres.get(i).getName());
        }
        return ResponseEntity.ok(genres1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieSearchService.findAll());
    }

}
