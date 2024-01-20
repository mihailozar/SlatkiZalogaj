package com.example.slatkizalogaj.ui.porudzbine;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KorpaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public KorpaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setmText(String text){mText.setValue(text);}
}