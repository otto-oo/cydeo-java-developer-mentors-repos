package com.builder.methodlevel_3;

import lombok.Builder;
import lombok.Value;

@Builder
@Value //  as it doesnt have setters @Value that makes objects immutable.
final class ImmutableStudent {
    private int id;
    private String name;
}