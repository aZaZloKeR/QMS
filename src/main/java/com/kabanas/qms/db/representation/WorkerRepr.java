package com.kabanas.qms.db.representation;

import lombok.Data;

import javax.persistence.Column;

@Data
public class WorkerRepr {
    private String firstName;
    private String secondName;
    private String phone;
    private String status;
    private int positionId;

    //for User
    private String login;
    private String password;
    private String role;
}
