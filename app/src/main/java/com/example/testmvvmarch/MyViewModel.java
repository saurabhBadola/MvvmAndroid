package com.example.testmvvmarch;

import android.util.Log;
import androidx.databinding.Bindable;

public class MyViewModel extends BaseViewModel<MyViewModel.MyState> {


    public void setFirstName(String firstName) {
        MyState state = getCurrentState();
        state.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        MyState state = getCurrentState();
        state.setLastName(lastName);
    }

    public void setPhoneNumber(String phoneNumber) {
        MyState state = getCurrentState();
        state.setPhoneNumber(phoneNumber);
    }

    @Override
    MyState createInitialState() {
        return new MyState("Default", "Default", "Default");
    }


    public static class MyState extends State {

        @Bindable
        private String firstName;
        @Bindable
        private String lastName;
        @Bindable
        private String phoneNumber;

        public MyState(String firstName, String lastName, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }


        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setFirstName(String firstName) {
          //  Log.d("Main.Act", "setFirstName: " + firstName);
            this.firstName = firstName;
            notifyPropertyChanged(BR.firstName);
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
            notifyPropertyChanged(BR.lastName);
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            notifyPropertyChanged(BR.phoneNumber);
        }

        @Override
        public String toString() {
            return "State{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }

    }
}
