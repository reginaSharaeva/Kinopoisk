package com.itis.dz.services.impl;

import com.itis.dz.entities.Comment;
import com.itis.dz.repositories.CommentRepository;
import com.itis.dz.repositories.MovieRepository;
import com.itis.dz.repositories.UserRepository;
import com.itis.dz.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;

    public Comment getCommentById(Long id) {
        return commentRepository.getCommentById(id);
    }

    public void addComment(Comment comment){commentRepository.addComment(comment);}

    public void addTestData() {
        Comment comment = new Comment("От фильмов подобного жанра никогда не жду новых впечатлений. Такие картины однообразны и предсказуемы.", Calendar.getInstance(),
                userRepository.getUserByLogin("vasya@mail.ru"),movieRepository.getMovieById((long)1));
        commentRepository.addComment(comment);
        Comment comment1=new Comment("Сценарий банален, но судить жанр за это глупо. Впечатление, что сценарий был написан один раз.",
                Calendar.getInstance(),
                userRepository.getUserByLogin("vasya@mail.ru"),movieRepository.getMovieById((long)1));
        commentRepository.addComment(comment1);
    }
}
