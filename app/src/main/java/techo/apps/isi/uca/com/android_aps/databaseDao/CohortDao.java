package techo.apps.isi.uca.com.android_aps.databaseDao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import techo.apps.isi.uca.com.android_aps.models.Carrer;
import techo.apps.isi.uca.com.android_aps.models.Cohort;

@Dao
public interface CohortDao {

    @Query("SELECT * FROM Cohort")
    List<Cohort> getAll();

    @Query("SELECT * FROM Cohort WHERE carrer = :carrer")
    Carrer loadByCarrer(Carrer carrer);

    @Insert
    void insert(Cohort cohort);

    @Query("SELECT * FROM Cohort cohort WHERE cohort.status LIKE :status")
    List<Cohort> loadByStatus(String status);


    @Delete
    void delete(Cohort cohort);

    @Update
    void update(Cohort cohort);

    @Query("DELETE FROM Cohort")
    void deleteAll();
}
