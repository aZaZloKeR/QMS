package com.kabanas.qms.db.model;

import com.kabanas.qms.db.key.ServiceWorkerKey;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Service_Worker")
public class ServiceWorker{
    @EmbeddedId
    ServiceWorkerKey serviceWorkerKey;

    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @MapsId("serviceId")
    @JoinColumn(name = "service_Id")
    private Service service;

    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @MapsId("workerId")
    @JoinColumn(name = "worker_Id")
    private Worker worker;
}
