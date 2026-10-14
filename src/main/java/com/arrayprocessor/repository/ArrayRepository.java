package com.arrayprocessor.repository;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import com.arrayprocessor.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayRepository {

    private static final Logger logger = LogManager.getLogger();

    private static ArrayRepository instance;

    private final List<AbstractArray> arrays = new ArrayList<>();

    private final List<ArrayObserver> observers = new ArrayList<>();

    private ArrayRepository() {
        logger.info("ArrayRepository init");
    }

    public static ArrayRepository getInstance() {
        if (instance == null) {
            instance = new ArrayRepository();
        }
        return instance;
    }

    public void add(AbstractArray array) throws ArrayProcessingException {
        if (array == null) {
            throw new ArrayProcessingException("Array must not be null");
        }
        if (arrays.contains(array)) {
            throw new ArrayProcessingException("Duplicate id: " + array.getId());
        }
        arrays.add(array);
        logger.info("Added array with id {}", array.getId());
        notifyAdded(array);
    }

    public void remove(long id) throws ArrayProcessingException {
        AbstractArray array = findById(id);
        arrays.remove(array);
        logger.info("Removed array with id {}", id);
        notifyRemoved(array);
    }

    public void update(long id, int index, int value) throws ArrayProcessingException {
        AbstractArray array = findById(id);
        array.setElement(index, value);
        logger.info("Updated array {} at index {} to {}", id, index, value);
        notifyChanged(array);
    }

    public AbstractArray findById(long id) throws ArrayProcessingException {
        for (AbstractArray array : arrays) {
            if (array.getId() == id) {
                return array;
            }
        }
        throw new ArrayProcessingException("Array with id " + id + " not found");
    }

    public List<AbstractArray> getAll() {
        return new ArrayList<>(arrays);
    }

    public List<AbstractArray> find(ArraySpecification specification) {
        List<AbstractArray> result = new ArrayList<>();
        for (AbstractArray array : arrays) {
            if (specification.test(array)) {
                result.add(array);
            }
        }
        return result;
    }

    public void addObserver(ArrayObserver observer) {
        observers.add(observer);
    }

    private void notifyAdded(AbstractArray array) {
        for (ArrayObserver observer : observers) {
            observer.onArrayAdded(array);
        }
    }

    private void notifyChanged(AbstractArray array) {
        for (ArrayObserver observer : observers) {
            observer.onArrayChanged(array);
        }
    }

    private void notifyRemoved(AbstractArray array) {
        for (ArrayObserver observer : observers) {
            observer.onArrayRemoved(array);
        }
    }
}
