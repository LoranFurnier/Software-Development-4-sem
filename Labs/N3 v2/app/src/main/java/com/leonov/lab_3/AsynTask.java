package com.leonov.lab_3;

import android.os.AsyncTask;

import com.leonov.lab_3.model.Student;

import java.sql.Date;

public class AsynTask extends AsyncTask<MainActivity,Void, Void>
{
    private final static String[] random_name={"Андреев Артём Александрович", "Вильнюссский Владислав Валерьевич", "Добродеев Денис Демьянович", "Изварина Изольда Игоревна", "Клоповник Карл Кириллович", "Льняной Лаврентий Львович", "Макаренко Максвелл Мелитонович", "Балабанов Борис Брониславович", "Гордеев Георгий Григорьевич", "Еремеев Евгений Евстигнеевич", "Жестокая Жаклин Жановна", "Носков Никодим Никанорович", "Ольбрыхская Ольга-Мария Олеговна"};

    public static String[] getRandom_name() {
        return random_name;
    }

    @Override
    protected Void doInBackground(MainActivity... splashes) {

        //Keys[] k =JsonLoader.getData();
        MainActivity m=splashes[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db= AppDatabase.getDatabase(m);
        db.getStudentDao().deleteAllStudents();

        Student[] students=new Student[5];
        for(int i=0;i<5;i++)
            students[i]=new Student();
        for(int i=0;i<5;i++)
        {
            String[] str=(AsynTask.getRandom_name()[(int)(Math.random()*AsynTask.getRandom_name().length)]).split(" ");
            students[i].setSurname(str[0]);
            students[i].setName(str[1]);
            students[i].setPatronym(str[2]);
            students[i].setDate(new java.sql.Date(System.currentTimeMillis()));

            db.getStudentDao().insertALL(students[i]);
        }
        m.CallMainAndDie();
        return null;
    }

    @Override
    protected void onPostExecute(Void v)
    {    }
}
