package com.kabanas.qms.db.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    @Column(name = "login")
    String login;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    String role;
}
