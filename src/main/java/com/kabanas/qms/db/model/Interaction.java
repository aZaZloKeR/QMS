package com.kabanas.qms.db.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Interaction")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "orig_Id")
    private int origId;
    @Column(name = "request_time")
    private Date requestTime;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "status")
    private String status;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "point_id")
    private InteractionPoint point;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private Service service;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    private Worker worker;

}
