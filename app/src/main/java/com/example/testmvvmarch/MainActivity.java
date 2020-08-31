package com.example.testmvvmarch;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BaseActivity<MyViewModel.MyState> {

    MyViewModel myViewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setMyViewModel(myViewModel);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_blank,blankFragment).commit();
    }

    @Override
    BaseViewModel<MyViewModel.MyState> createViewModel() {
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        return myViewModel;
    }

    @Override
    void onStateChanged( MyViewModel.MyState newState) {
        Log.d("Main.Act", "onStateChanged: New: "+newState);
    }
}