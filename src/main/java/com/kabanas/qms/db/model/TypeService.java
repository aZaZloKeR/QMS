package com.kabanas.qms.db.model;


import com.kabanas.qms.db.key.TypeServiceKey;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Type_service") //надо переименовать в бд
public class TypeService {
    @EmbeddedId
    TypeServiceKey typeServiceKey;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("typeId")
    @JoinColumn(name = "type_id")
    private InteractionTypePoint type;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private Service service;


}
