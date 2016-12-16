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

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String renderAddingMovieView() {
        return "movie/newMovie";
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String renderEditMovieView(@PathVariable("id") Long id) {
        request.setAttribute("movie", movieService.getMovieById(id));
        request.setAttribute("comments_count", movieService.getMovieById(id).getComments().size());
        return "movie/editMovie";
    }
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<List<Movie>> search(@RequestParam(required = false) String search, String searchBy, String sort) {

        List<Movie> movies;

        if (!search.isEmpty()) {
            movies = movieSearchService.searsh(search,searchBy,sort);
        }else{
            movies = movieSearchService.findAll(sort);
        }
        return ResponseEntity.ok(movies);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/autocomplete")
    public ResponseEntity<String> searchAuto(@RequestParam String q) {
        return ResponseEntity.ok(movieSearchService.autocomplete(q));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fullSearch")
    public ResponseEntity<List<Movie>> fullSearch(@RequestParam(required = false) String search,String searchBy, String genres, String from, String to,String sort) {
        List<String> genresList = new ArrayList<>();
        if (!genres.isEmpty()) {
            StringTokenizer tokenizer = new StringTokenizer(genres + ",");
            while (tokenizer.hasMoreTokens()) {
                genresList.add(tokenizer.nextToken(","));
            }
        }
        List<Movie> genreArrayList;

        if(search.isEmpty()&&genres.isEmpty()&&from.isEmpty()&&to.isEmpty()) {
            genreArrayList=movieSearchService.findAll(sort);
        }else{

            genreArrayList = movieSearchService.fullSearsh(search, searchBy, genresList, from, to, sort);
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

    @RequestMapping(method = RequestMethod.POST, value = "/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) String sort) {
        return ResponseEntity.ok(movieSearchService.findAll(sort));
    }
    
}
