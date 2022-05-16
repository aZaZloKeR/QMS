package com.kabanas.qms.service;

import com.kabanas.qms.db.model.Users;
import com.kabanas.qms.db.repository.InteractionPointRepo;
import com.kabanas.qms.db.repository.UsersRepo;
import com.kabanas.qms.db.representation.AuthRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class AuthService {
    @Autowired
    InteractionPointRepo interactionPointRepo;
    @Autowired
    UsersRepo usersRepo;


    private Cookie creteCookie(String role, int id){
        Cookie cookie = new Cookie("auth", id + "," + role);
        cookie.setPath("/");
        cookie.setMaxAge(86400);
        return cookie;
    }
    public ResponseEntity<?> checkAuth(AuthRepresentation authRepresentation, HttpServletResponse response){
        if(usersRepo.findByLogin(authRepresentation.getLogin()).isPresent()) {
            Users user = usersRepo.findByLogin(authRepresentation.getLogin()).get();
            if (authRepresentation.getPassword().equals(user.getPassword())) {
                response.addCookie(creteCookie(user.getRole(), user.getId()));
            }
        }// можно в теории отправлять инфу о том что такого логина нет, или пароль не правильный
        response.setContentType("text/plain");
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
