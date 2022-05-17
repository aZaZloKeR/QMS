package com.kabanas.qms.db.model;

import com.kabanas.qms.db.key.PositionDefaultServiceKey;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Position_Default_Service")
public class PositionDefaultService implements Serializable {
    @EmbeddedId
    PositionDefaultServiceKey positionDefaultServiceKey;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("positionId")
    @JoinColumn(name = "position_Id")
    private Position position;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("serviceId")
    @JoinColumn(name = "service_Id")
    private Service service;


}
