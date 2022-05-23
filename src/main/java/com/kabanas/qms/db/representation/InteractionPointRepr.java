package com.kabanas.qms.db.representation;

import lombok.Data;

@Data
public class InteractionPointRepr {
    private Integer id;
    private String name;
    private Boolean active;
    private Integer typeId;
}
