package com.kabanas.qms.db.model;


import com.kabanas.qms.db.key.TempPointWorkerKey;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "temp_point_worker")
public class TempPointWorker{
    @EmbeddedId
    TempPointWorkerKey tempPointWorkerKey;

    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @MapsId("workerId")
    @JoinColumn(name = "worker_Id")
    private Worker worker;

    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @MapsId("pointId")
    @JoinColumn(name = "point_Id")
    private InteractionPoint interactionPoint;

}
