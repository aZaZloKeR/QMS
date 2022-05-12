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

    @OneToMany (mappedBy="customer", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<Interaction> interactions;

  /*  public void setPhone(String phone) {
        if ((phone.length() == 12 && phone.charAt(0)!='+') || (phone.length() == 11)) // впадлу полную проверку номера телефона писать
            this.phone = phone;
        else try {
            throw new Exception("Введите правильный номер телефона");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
