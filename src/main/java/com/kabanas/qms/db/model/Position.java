package com.kabanas.qms.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany (mappedBy ="position",fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<Worker> workers;
    @OneToMany (mappedBy="position", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<PositionDefaultService> positionDefaultServices;
}
