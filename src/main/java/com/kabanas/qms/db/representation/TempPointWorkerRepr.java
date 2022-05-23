package com.kabanas.qms.db.representation;

import lombok.Data;

import java.util.Date;

@Data
public class TempPointWorkerRepr {
    private Integer pointId;
    private  Integer workerId;
    private Date startTime;
    private Date endTime;
}
