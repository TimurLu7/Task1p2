package com.arrayprocessor.repository.impl;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.repository.ArraySpecification;

public class ByIdSpecification implements ArraySpecification {

    private final long id;

    public ByIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean test(AbstractArray array) {
        return array.getId() == id;
    }
}

