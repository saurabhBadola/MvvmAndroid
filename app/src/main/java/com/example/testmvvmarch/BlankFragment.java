package com.example.testmvvmarch;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.example.testmvvmarch.databinding.FragmentBlankBinding;
import java.util.Random;

public class BlankFragment extends Fragment {

    public static final String TAG = "BlankFrag.TAG";

    private MyViewModel myViewModel;
    FragmentBlankBinding blankBinding;

    public void setMyViewModel(MyViewModel myViewModel) {
        this.myViewModel = myViewModel;
    }

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        blankBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false);
        return blankBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        blankBinding.setViewModel(myViewModel);
        blankBinding.setLifecycleOwner(this);

        blankBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] names = new String[]{"Aloe", "Hari", "Ram", "Raman", "Ankur", "Ankit"};
                Log.d(TAG, "onClick: ");
                myViewModel.setFirstName(names[new Random().nextInt(6)]);
            }
        });

        blankBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] names = new String[]{"Kumar", "Singh", "Joshi", "Malhotra", "Kapoor", "Khan"};
                Log.d(TAG, "onClick: ");
                myViewModel.setLastName(names[new Random().nextInt(6)]);
            }
        });


        blankBinding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] names = new String[]{"7877221432", "215234434", "3245454522", "25225452524", "222552522", "124325332"};
                Log.d(TAG, "onClick: ");
                myViewModel.setPhoneNumber(names[new Random().nextInt(6)]);
            }
        });


    }
}