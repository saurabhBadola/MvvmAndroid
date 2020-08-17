package com.example.testmvvmarch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.listen().observe(this, new Observer<MyViewModel.MyState>() {
            @Override
            public void onChanged(MyViewModel.MyState state) {
                Log.d("Main.TAG", "onChanged: "+state);
            }
        });


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] names = new String[]{"Aloe","Hari","Ram","Raman","Ankur","Ankit"};
                myViewModel.setFirstName(names[new Random().nextInt(6)]);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] names = new String[]{"Kumar","Singh","Joshi","Malhotra","Kapoor","Khan"};
                myViewModel.setLastName(names[new Random().nextInt(6)]);
            }
        });



        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] names = new String[]{"7877221432","215234434","3245454522","25225452524","222552522","124325332"};
                myViewModel.setPhoneNumber(names[new Random().nextInt(6)]);
            }
        });


    }
}