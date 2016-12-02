package com.itis.dz.services;

import com.itis.dz.entities.Comment;

import javax.transaction.Transactional;

public interface CommentService {
    @Transactional
    Comment getCommentById(Long id);
}
