package com.arrayprocessor.repository.comparator;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.entity.ArrayStatistics;
import com.arrayprocessor.entity.ArrayWarehouse;

import java.util.Comparator;

public class ArrayBySumComparator implements Comparator<AbstractArray> {

    @Override
    public int compare(AbstractArray first, AbstractArray second) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        ArrayStatistics firstStats = warehouse.getStatistics(first.getId());
        ArrayStatistics secondStats = warehouse.getStatistics(second.getId());
        if (firstStats == null && secondStats == null) {
            return 0;
        }
        if (firstStats == null) {
            return -1;
        }
        if (secondStats == null) {
            return 1;
        }
        return Integer.compare(firstStats.getSum(), secondStats.getSum());
    }
}
