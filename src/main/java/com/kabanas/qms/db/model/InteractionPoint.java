package com.kabanas.qms.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Interaction_Point")
public class InteractionPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "type_Id")
    private InteractionTypePoint type;

    @OneToMany (mappedBy="point", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<Interaction> interactions;

}