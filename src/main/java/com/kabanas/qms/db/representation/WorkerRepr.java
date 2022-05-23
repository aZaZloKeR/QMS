package com.kabanas.qms.db.representation;

import lombok.Data;

import javax.persistence.Column;

@Data
public class WorkerRepr {
    private Integer id;
    private String firstName;
    private String secondName;
    private String phone;
    private String status;
    private Integer positionId;

    //for User
    private Integer userId;
    private String login;
    private String password;
    private String role;
}
