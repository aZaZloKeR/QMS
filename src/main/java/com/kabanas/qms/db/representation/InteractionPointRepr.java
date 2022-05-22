package com.kabanas.qms.db.representation;

import lombok.Data;

@Data
public class InteractionPointRepr {
    private String name;
    private boolean active;
    private int typeId;
}
