package com.example.testmvvmarch;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

abstract public class BaseActivity<T extends State> extends AppCompatActivity {

    private BaseViewModel<T> baseViewModel;

    abstract BaseViewModel<T> createViewModel();
    abstract void onStateChanged(T oldState, T newState);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseViewModel = createViewModel();
        baseViewModel.listen().observe(this, new Observer<T>() {
            @Override
            public void onChanged(T t) {
                onStateChanged(baseViewModel.getCurrentState(), t);
            }
        });
    }
}
