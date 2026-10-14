package com.arrayprocessor.entity;
import com.arrayprocessor.exception.ArrayProcessingException;
import java.util.Arrays;

public class IntArray extends AbstractArray {

    private final int[] elements;

    public IntArray(long id, int[] elements) {
        super(id);
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    @Override
    public int[] getElements() {
        return Arrays.copyOf(elements, elements.length);
    }

    @Override
    public int length() {
        return elements.length;
    }

    @Override
    public void setElement(int index, int value) throws ArrayProcessingException {
        if (index < 0 || index >= elements.length) {
            throw new ArrayProcessingException("Index out of bounds: " + index);
        }
        elements[index] = value;
    }

    @Override
    public String toString() {
        return "IntArray{id= + getId() + ,elements=" + Arrays.toString(elements) + '}';
    }
}
