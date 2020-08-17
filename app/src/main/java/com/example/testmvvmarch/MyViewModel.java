package com.example.testmvvmarch;
public class MyViewModel extends BaseViewModel<MyViewModel.MyState> {

    public void setFirstName(String firstName){
        MyState state = getCurrentState();
        state.setFirstName(firstName);
        setState(state);
}

    public void setLastName(String lastName){
        MyState state = getCurrentState();
        state.setLastName(lastName);
        setState(state);
    }

    public void setPhoneNumber(String phoneNumber){
        MyState state = getCurrentState();
        state.setPhoneNumber(phoneNumber);
        setState(state);
    }

    @Override
    MyState createInitialState() {
        return new MyState("Default","Default","Default");
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }


    static class MyState extends State{
        private String firstName;
        private String lastName;
        private String phoneNumber;

        public MyState(String firstName, String lastName, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
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
