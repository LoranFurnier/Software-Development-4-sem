package com.leonov.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private AsynTask as;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        as =new AsynTask();
        as.execute(this);
    }


    public void CallMainAndDie()
    {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
