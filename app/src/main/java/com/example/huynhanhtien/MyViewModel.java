package com.example.huynhanhtien;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private MutableLiveData<ArrayList<String>> arrayList;
    public LiveData<ArrayList<String>> getArrayList(){
        if (arrayList == null){
            arrayList = new MutableLiveData<ArrayList<String>>();
            arrayList.setValue(new ArrayList<String>());

        }
        return arrayList;
    }



}