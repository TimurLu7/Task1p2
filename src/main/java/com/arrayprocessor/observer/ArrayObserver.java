package com.arrayprocessor.observer;

import com.arrayprocessor.entity.AbstractArray;

public interface ArrayObserver {

    void onArrayChanged(AbstractArray array);

    void onArrayAdded(AbstractArray array);

    void onArrayRemoved(AbstractArray array);
}