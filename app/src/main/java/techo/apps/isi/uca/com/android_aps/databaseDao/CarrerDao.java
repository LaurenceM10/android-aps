package techo.apps.isi.uca.com.android_aps.databaseDao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import techo.apps.isi.uca.com.android_aps.models.Carrer;

@Dao
public interface CarrerDao {
    @Query("SELECT * FROM Carrer order by id desc")
    List<Carrer> getAll();

    @Query("SELECT * FROM Carrer WHERE id = :id")
    Carrer loadById(int id);

    @Insert
    void insert(Carrer carrer);

    @Query("SELECT * FROM Carrer c WHERE c.name LIKE :name")
    List<Carrer> loadByName(String name);


    @Delete
    void delete(Carrer carrer);

    @Update
    void update(Carrer carrer);

    @Query("DELETE FROM Carrer")
    void deleteAll();

    @Query("Select * from Carrer order by id DESC LIMIT 1")
    Carrer getLastId();
}
