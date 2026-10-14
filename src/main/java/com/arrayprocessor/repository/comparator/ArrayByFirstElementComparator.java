package com.arrayprocessor.repository.comparator;

import com.arrayprocessor.entity.AbstractArray;

import java.util.Comparator;

public class ArrayByFirstElementComparator implements Comparator<AbstractArray> {

    @Override
    public int compare(AbstractArray first, AbstractArray second) {
        int[] firstElements = first.getElements();
        int[] secondElements = second.getElements();
        if (firstElements.length == 0 && secondElements.length == 0) {
            return 0;
        }
        if (firstElements.length == 0) {
            return -1;
        }
        if (secondElements.length == 0) {
            return 1;
        }
        return Integer.compare(firstElements[0], secondElements[0]);
    }
}