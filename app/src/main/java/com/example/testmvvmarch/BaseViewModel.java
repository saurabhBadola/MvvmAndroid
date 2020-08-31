package com.example.testmvvmarch;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<T extends State> extends ViewModel implements Observable {

    private CustomMutableLiveData<T> state = new CustomMutableLiveData<>(createInitialState());
    public T oldState;

    abstract T createInitialState();

    T getCurrentState() {
        return state.getValue();
    }

    public MutableLiveData<T> listen() {
        return state;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
