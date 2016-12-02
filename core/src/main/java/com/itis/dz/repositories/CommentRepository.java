package com.itis.dz.repositories;

import com.itis.dz.entities.Comment;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public Comment getCommentById(Long id) {
        return (Comment) sessionFactory.getCurrentSession().createCriteria(Comment.class).add(Restrictions.idEq(id)).uniqueResult();
    }

    public void addComment(Comment comment) {
        sessionFactory.getCurrentSession().save(comment);
    }
}

