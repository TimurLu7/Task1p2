package com.arrayprocessor.repository.comparator;

import com.arrayprocessor.entity.AbstractArray;

import java.util.Comparator;

public class ArrayByIdComparator implements Comparator<AbstractArray> {

    @Override
    public int compare(AbstractArray first, AbstractArray second) {
        return Long.compare(first.getId(), second.getId());
    }
}
