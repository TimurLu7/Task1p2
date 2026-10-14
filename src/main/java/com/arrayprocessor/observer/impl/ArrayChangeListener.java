package com.arrayprocessor.observer.impl;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.entity.ArrayWarehouse;
import com.arrayprocessor.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayChangeListener implements ArrayObserver {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void onArrayChanged(AbstractArray array) {
        logger.debug("Array changed: {}", array.getId());
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        warehouse.recalculate(array);
    }

    @Override
    public void onArrayAdded(AbstractArray array) {
        logger.debug("Array added: {}", array.getId());
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        warehouse.recalculate(array);
    }

    @Override
    public void onArrayRemoved(AbstractArray array) {
        logger.debug("Array removed: {}", array.getId());
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        warehouse.remove(array.getId());
    }
}
