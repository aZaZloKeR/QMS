package com.kabanas.qms.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "second_Name")
    private String secondName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "isFree")
    private boolean free;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "position_Id")
    private Position position;

    @OneToMany (mappedBy="worker", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<Interaction> interactions;
    @OneToMany (mappedBy = "worker",fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<ServiceWorker> serviceWorkers;
    @OneToMany (mappedBy = "worker",fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<TempPointWorker> tempPointWorkers;
}
