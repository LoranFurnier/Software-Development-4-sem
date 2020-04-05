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
    protected Void doInBackground(MainActivity... splasches) {

        //Keys[] k =JsonLoader.getData();
        MainActivity m=splasches[0];
        //m.CallMainAndDie(k.clone());
        AppDatabase db= AppDatabase.getDatabace(m);
        db.getStudentDao().deleteAllStudents();
        Student[] students=new Student[5];
        for(int i=0;i<5;i++)
            students[i]=new Student();
        for(int i=0;i<5;i++)
        {
            students[i].setFIO(random_name[(int)(Math.random()*random_name.length)]);
            students[i].setDate(new Date(System.currentTimeMillis()));

            db.getStudentDao().insertALL(students[i]);
        }

        m.CallMainAndDie();

        return null;
    }

    @Override
    protected void onPostExecute(Void v)
    {

    }
}
