package com.arrayprocessor.repository.impl;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.entity.ArrayStatistics;
import com.arrayprocessor.entity.ArrayWarehouse;
import com.arrayprocessor.repository.ArraySpecification;

public class CountGreaterThanSpecification implements ArraySpecification {

    private final int threshold;

    public CountGreaterThanSpecification(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(AbstractArray array) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        ArrayStatistics stats = warehouse.getStatistics(array.getId());
        return stats != null && stats.getCount() > threshold;
    }
}
