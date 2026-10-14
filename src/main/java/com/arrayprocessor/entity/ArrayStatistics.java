package com.arrayprocessor.entity;

public class ArrayStatistics {

    private final int sum;
    private final double average;
    private final int min;
    private final int max;
    private final int count;

    public ArrayStatistics(int sum, double average, int min, int max, int count) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ArrayStatistics{sum=" + sum + ", average=" + average
                + ", min=" + min + ", max=" + max + ", count=" + count + '}';
    }
}
