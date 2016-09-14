package com.github.slamdev.morrigna.toolset.business.attributes;

import lombok.*;

import javax.enterprise.context.Dependent;
import java.util.List;

@Data
@Builder
@Dependent
@NoArgsConstructor
@AllArgsConstructor
public class EnumerationAttributeType implements AttributeType {

    private static final String CODE = "ENUM";

    @Singular
    private List<Descriptor> descriptors;

    @Override
    public String getCode() {
        return CODE;
    }

    @Data
    @Builder
    public static class Descriptor {
        private String code;
        private String name;
        @Singular
        private List<String> tags;
        private String description;
    }
}
