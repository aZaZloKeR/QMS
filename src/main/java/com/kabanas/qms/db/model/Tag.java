package com.kabanas.qms.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;

    @OneToMany (mappedBy = "tag",fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<WorkerTag> workerTags;
    @OneToMany (mappedBy="tag", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<PositionDefaultTag> positionDefaultTags;
    @OneToMany (mappedBy="tag", fetch=FetchType.EAGER)
    @JsonIgnore
    private Collection<TagService> tagServices;
}
