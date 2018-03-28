package com.example.allison.demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class OtherActivity extends AppCompatActivity {
    static APIHelper helper;
    static ArrayList<APIHelper.ListItem> item = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        helper = (APIHelper)getApplicationContext();
        helper.setCurrentUrl("http://acousti.co/feeds/venue/the%20garrick%20center");
        helper.setCurrentActivity(this);
        helper.sendRequest();
    }

    public static void getData(){
        item = helper.getItem();
        for(APIHelper.ListItem i: item){
            Log.d("RSS - other", i.getTitle());
        }
    }
}
