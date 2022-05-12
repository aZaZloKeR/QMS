package com.kabanas.qms.db.key;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@EqualsAndHashCode
public class TypeServiceKey implements Serializable {
    private int typeId;
    private int serviceId;
}
