package com.kabanas.qms.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Interaction_Type_Point")
public class InteractionTypePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany (mappedBy="type", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<InteractionPoint> interactionPoints;
    @OneToMany (mappedBy="type", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<TypeService> typeServices;
}
