package com.kabanas.qms.db.key;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@EqualsAndHashCode
public class ServiceWorkerKey implements Serializable {
    private int serviceId;
    private int workerId;
}