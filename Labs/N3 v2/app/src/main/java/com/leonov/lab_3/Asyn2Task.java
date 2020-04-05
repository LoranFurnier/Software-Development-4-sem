package com.leonov.lab_3;

import android.os.AsyncTask;

import com.leonov.lab_3.model.Student;

import java.util.List;

public class Asyn2Task extends AsyncTask<Main2Activity,Void, Void> {

    @Override
    protected Void doInBackground(Main2Activity... splasches) {

        Main2Activity m=splasches[0];
        AppDatabase db= AppDatabase.getDatabase(m);

        switch (m.getEvent_Description())
        {

            case 1:
                List<Student> list=db.getStudentDao().getAllStudents();
                m.finisher(list);
                break;

            case 2:
                Student student=new Student();
                String[] str=(AsynTask.getRandom_name()[(int)(Math.random()*AsynTask.getRandom_name().length)]).split(" ");
                student.setSurname(str[0]);
                student.setName(str[1]);
                student.setPatronym(str[2]);
                student.setDate(new java.sql.Date(System.currentTimeMillis()));
                db.getStudentDao().insertALL(student);
                break;

            case 3:
                db.getTransactor().ChangeLast();
                break;

        }
        return null;
    }
}
