package com.github.slamdev.morrigna.toolset.business.attributes;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class EnumerationAttributeType implements AttributeType {

    @Singular
    private List<Descriptor> descriptors = new ArrayList<>();

    @Data
    @Builder
    public static class Descriptor {
        private String code;
        private String name;
        private List<String> tags;
        private String description;
    }
}
