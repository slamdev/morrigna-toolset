package com.github.slamdev.morrigna.toolset.business.attributes;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Attribute {

    private String refId;
    private String code;
    private String name;
    private String description;
    private List<String> tags;
    private AttributeType type;
    private String calculationScript;
}
