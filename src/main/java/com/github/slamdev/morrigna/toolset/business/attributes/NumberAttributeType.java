package com.github.slamdev.morrigna.toolset.business.attributes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumberAttributeType implements AttributeType {

    private double minValue;
    private double maxValue;
}
