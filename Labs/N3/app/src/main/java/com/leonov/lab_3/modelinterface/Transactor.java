package com.leonov.lab_3.modelinterface;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import com.leonov.lab_3.model.Student;

import java.util.List;

@Dao
public abstract class Transactor {

    @Query("SELECT * FROM Student WHERE id=(SELECT MAX(id) FROM Student)")
   public abstract List<Student> getLast();

    @Update
    public abstract void update(Student student);


    @Transaction
    public void ChangeLast()
    {
        Student s=getLast().get(0);
        s.setFIO("Иванов Иван Иванович");
        update(s);
    }

}
