package com.kabanas.qms.db.model;

import com.kabanas.qms.db.key.TagServiceKey;
import com.kabanas.qms.db.key.TypeServiceKey;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Tag_Service")
public class TagService implements Serializable {
    @EmbeddedId
    TagServiceKey tagServiceKey;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("tagId")
    @JoinColumn(name = "tag_Id")
    private Tag tag;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("serviceId")
    @JoinColumn(name = "service_Id")
    private Service service;
}
