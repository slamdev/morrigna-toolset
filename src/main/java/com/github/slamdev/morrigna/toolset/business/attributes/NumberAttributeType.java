package com.github.slamdev.morrigna.toolset.business.attributes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.enterprise.context.Dependent;

@Data
@Builder
@Dependent
@NoArgsConstructor
@AllArgsConstructor
public class NumberAttributeType implements AttributeType {

    private static final String CODE = "NUMBER";

    private double minValue;
    private double maxValue;

    @Override
    public String getCode() {
        return CODE;
    }
}
