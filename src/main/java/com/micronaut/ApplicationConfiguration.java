package com.micronaut;


import javax.validation.constraints.NotNull;

public interface ApplicationConfiguration {
    @NotNull    Integer getMax();
}
