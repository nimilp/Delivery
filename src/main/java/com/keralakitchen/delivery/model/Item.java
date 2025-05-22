package com.keralakitchen.delivery.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

    @Schema(example = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "")
    private String id;
    @Schema(example = "Vegitarian", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "")
    private String name;
    @Schema(example = "", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "")
    private String Desc;
}
