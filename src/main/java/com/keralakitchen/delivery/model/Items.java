package com.keralakitchen.delivery.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
public class Items {

    @Schema(example = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "")
    private String id;
    @Schema(example = "Vegitarian", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "")
    private String name;
    @Schema(example = "", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "")
    private String otherName;
    @Schema(example = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "")
    private String description;
    @Schema(example = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String parentId;
}
