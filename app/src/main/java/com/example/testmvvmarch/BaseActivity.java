package com.example.testmvvmarch;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

abstract public class BaseActivity<T extends State> extends AppCompatActivity {

    private BaseViewModel<T> baseViewModel;

    abstract BaseViewModel<T> createViewModel();
    abstract void onStateChanged( T newState);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseViewModel = createViewModel();
      //  baseViewModel.listen().removeObservers(this);
        baseViewModel.listen().observe(this, new Observer<T>() {
            @Override
            public void onChanged(T t) {

              //  Log.d("Main.Act", "onChanged: "+t.toString());
             //   T oldState = baseViewModel.oldState;
               // Log.d("Main.Act", "Old state: "+oldState);
                onStateChanged(t);
            }
        });
    }
}
