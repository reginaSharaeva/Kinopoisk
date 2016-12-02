package com.itis.dz.services.impl;

import com.itis.dz.entities.Comment;
import com.itis.dz.repositories.CommentRepository;
import com.itis.dz.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment getCommentById(Long id) {
        return commentRepository.getCommentById(id);
    }

}
