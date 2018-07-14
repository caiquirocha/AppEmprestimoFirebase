package com.example.iossenac.appemprestimofirebase;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ControlApp extends Application {

    public static DatabaseReference myRef;

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }
}