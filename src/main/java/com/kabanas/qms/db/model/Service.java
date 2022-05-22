package com.kabanas.qms.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "isActive")
    private boolean active;
    @Column(name = "isVisible_for_client")
    private boolean visibleForClient;

    @OneToMany (mappedBy="service", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<Interaction> interactions;
    @OneToMany (mappedBy="service", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<TypeService> typeServices;
    @OneToMany (mappedBy="service", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<PositionDefaultService> positionDefaultServices;
    @OneToMany (mappedBy="service", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<ServiceWorker> serviceWorkers;
}
