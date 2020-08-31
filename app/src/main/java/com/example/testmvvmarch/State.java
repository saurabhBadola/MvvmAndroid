package com.example.testmvvmarch;

import androidx.databinding.BaseObservable;

public class State extends BaseObservable {
    private boolean handled = false;

    public boolean isHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }
}
