package com.example.testmvvmarch;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

abstract public class BaseActivity extends AppCompatActivity {

    private BaseViewModel<State> baseViewModel = createViewModel();

    abstract BaseViewModel<State> createViewModel();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        baseViewModel.listen().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {

            }
        });
    }
}
