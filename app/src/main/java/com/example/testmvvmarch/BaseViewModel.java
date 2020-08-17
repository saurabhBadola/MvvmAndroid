package com.example.testmvvmarch;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<T extends  State> extends ViewModel implements Observable {

    @Bindable
    private MutableLiveData<T> state = new MutableLiveData<>(createInitialState());

   abstract  T createInitialState();
   protected T getCurrentState(){
        return state.getValue();
    }

    public MutableLiveData<T> listen(){
        return state;
    }

   protected void setState(T newState){
        state.postValue(newState);
    }


    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
