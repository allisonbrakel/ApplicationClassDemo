package com.example.allison.demo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    static APIHelper helper;
    static ArrayList<APIHelper.ListItem> item = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = (APIHelper)getApplicationContext();
        helper.setCurrentActivity(this);

        Button otherActivity = findViewById(R.id.otherActivity);
        otherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(i);
            }
        });
    }

    // Static so that its accessible in any instance of MainActivity
    public static void getData(){
        item = helper.getItem();
        for(APIHelper.ListItem i: item){
            Log.d("RSS - main", i.getTitle());
        }
    }
}
