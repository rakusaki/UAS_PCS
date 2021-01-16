package com.example.uas_0593.ui.berlangsung;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BerlangsungViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BerlangsungViewModel() {
        //mText = new MutableLiveData<>();
        //mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}