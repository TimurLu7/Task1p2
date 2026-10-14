package com.arrayprocessor.factory;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.entity.IntArray;
import com.arrayprocessor.exception.ArrayProcessingException;

public class  IntArrayFactory implements ArrayFactory {
    private static IntArrayFactory instance;
    private long idGenerator = 0;

    private IntArrayFactory() {}

    public static IntArrayFactory getInstance() {
        if (instance == null){
            instance = new IntArrayFactory();
        }
        return instance;
    }

    @Override
    public AbstractArray create(int[] elements) throws ArrayProcessingException {
        if (elements == null) {
            throw new ArrayProcessingException("Elements array must not be null");
        }
        if (elements.length == 0) {
            throw new ArrayProcessingException("Elements array must not be empty");
        }
        long id = ++idGenerator;
        return new IntArray(id,elements);
    }
}
