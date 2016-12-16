package com.itis.dz.security;

import com.itis.dz.entities.User;
import org.springframework.security.core.context.SecurityContextHolder;


public class AuthorizedUsersInfo {
    /**
     *
     * @return авторизованного пользователя  или null, если его нет
     */
    public static User getCurrentUser() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof MyUserDetail) return ((MyUserDetail) principal).getUser();

        return null;
    }


    /**
     * Утилита для определения, авторизован ли пользователь
     *
     * @return true-если пользователь авторизован, false-пользователь не авторизован
     */
    public static boolean isLoggedIn() {
        return getCurrentUser() != null;
    }
}
