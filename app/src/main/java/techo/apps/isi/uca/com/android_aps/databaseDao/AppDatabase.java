package techo.apps.isi.uca.com.android_aps.databaseDao;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import techo.apps.isi.uca.com.android_aps.models.*;

@Database(entities = {Person.class, Student.class, Carrer.class, Cohort.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
    public abstract StudentDao studentDao();
    public abstract CarrerDao carrerDao();


}
