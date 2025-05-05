package com.keralakitchen.delivery.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @Schema(example = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "")
    private String id;
    @Schema(example = "John", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "")
    private String firstName;
    @Schema(example = "Doe", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "")
    private String lastName;
    @Schema(example = "Customer", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "")
    private String type;
}
