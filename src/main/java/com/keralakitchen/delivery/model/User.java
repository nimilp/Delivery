package com.keralakitchen.delivery.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class User {

    @Schema(name = "First Name", example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;
    @Schema(name = "Last Name", example = "Doe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;
    @Schema(name = "User Type", example = "Customer", requiredMode = Schema.RequiredMode.REQUIRED)
    private String type;
}
