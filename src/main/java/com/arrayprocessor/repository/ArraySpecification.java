package com.arrayprocessor.repository;

import com.arrayprocessor.entity.AbstractArray;

public interface ArraySpecification {

    boolean test(AbstractArray array);
}
