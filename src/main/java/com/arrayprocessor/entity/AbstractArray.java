package com.arrayprocessor.entity;

import com.arrayprocessor.exception.ArrayProcessingException;

public abstract class  AbstractArray {

    private final long id;

    protected AbstractArray(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public abstract int[] getElements();

    public abstract int length();

    public abstract void setElement(int index, int value) throws ArrayProcessingException;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractArray that = (AbstractArray) obj;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return "AbstractArray{id=" + id + '}';
    }
}
