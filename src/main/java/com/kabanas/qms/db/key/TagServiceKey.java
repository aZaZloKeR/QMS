package com.kabanas.qms.db.key;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@EqualsAndHashCode
public class TagServiceKey implements Serializable {
    private int tagId;
    private int serviceId;
}
