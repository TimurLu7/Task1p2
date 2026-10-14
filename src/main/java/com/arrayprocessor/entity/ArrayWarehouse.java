package com.arrayprocessor.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {

    private static final Logger logger = LogManager.getLogger();

    private static ArrayWarehouse instance;

    private final Map<Long, ArrayStatistics> statistics = new HashMap<>();

    private ArrayWarehouse() {
        logger.info("ArrayWarehouse created");
    }

    public static ArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new ArrayWarehouse();
        }
        return instance;
    }

    public void recalculate(AbstractArray array) {
        int[] elements = array.getElements();
        if (elements.length == 0) {
            statistics.remove(array.getId());
            return;
        }
        int sum = 0;
        int min = elements[0];
        int max = elements[0];
        for (int element : elements) {
            sum += element;
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
        }
        double average = (double) sum / elements.length;
        ArrayStatistics stats = new ArrayStatistics(sum, average, min, max, elements.length);
        statistics.put(array.getId(), stats);
        logger.debug("Recalculated stats for array {}: {}", array.getId(), stats);
    }

    public void remove(long id) {
        statistics.remove(id);
        logger.debug("Removed stats for array {}", id);
    }

    public ArrayStatistics getStatistics(long id) {
        return statistics.get(id);
    }
}
