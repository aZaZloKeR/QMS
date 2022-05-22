package com.kabanas.qms.db.key;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@EqualsAndHashCode
public class PositionDefaultServiceKey implements Serializable {
    private int positionId;
    private int serviceId;
}
