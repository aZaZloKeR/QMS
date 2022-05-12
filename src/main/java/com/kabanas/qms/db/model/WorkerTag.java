package com.kabanas.qms.db.model;

import com.kabanas.qms.db.key.TypeServiceKey;
import com.kabanas.qms.db.key.WorkerTagKey;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Worker_Tag")
public class WorkerTag implements Serializable {
    @EmbeddedId
    WorkerTagKey workerTagKey;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("workerId")
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;

}
