package com.arrayprocessor.repository.comparator;

import com.arrayprocessor.entity.AbstractArray;

import java.util.Comparator;

public class ArrayByLengthComparator implements Comparator<AbstractArray> {

    @Override
    public int compare(AbstractArray first, AbstractArray second) {
        return Integer.compare(first.length(), second.length());
    }
}