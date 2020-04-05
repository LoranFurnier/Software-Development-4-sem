package com.leonov.lab_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.leonov.lab_3.model.Student;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    ListView listview;
    Model model;
    ArrayList<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        list= (ArrayList<Student>) getIntent().getExtras().getSerializable("list");
        listview = (ListView) findViewById(R.id.listview);
        model =new Model(this,list);
        listview.setAdapter(model);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}
