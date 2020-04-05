package com.leonov.lab_3;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.leonov.lab_3.model.Student;
import com.leonov.lab_3.modelinterface.StudentDao;
import com.leonov.lab_3.modelinterface.Transactor;

@Database(entities = {Student.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao getStudentDao();
    public abstract Transactor getTeansactor();
    private static AppDatabase db;

    public static AppDatabase getDatabace(Context context)
    {
        if(db==null)
        {
            db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database")
                    .build();
        }

        return db;
    }


}
