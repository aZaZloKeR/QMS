package com.kabanas.qms.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "second_Name")
    private String secondName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "identity_document")
    private String identityDocument;

    @OneToMany (mappedBy="customer", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<Interaction> interactions;

}
