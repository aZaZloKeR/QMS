package com.kabanas.qms.db.model;

import com.kabanas.qms.db.key.PositionDefaultTagKey;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity
@Table(name = "Position_Default_Tag")
public class PositionDefaultTag implements Serializable {
    @EmbeddedId
    PositionDefaultTagKey positionDefaultTagKey;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("positionId")
    @JoinColumn(name = "position_Id")
    private Position position;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("tagId")
    @JoinColumn(name = "tag_Id")
    private Tag tag;


}
