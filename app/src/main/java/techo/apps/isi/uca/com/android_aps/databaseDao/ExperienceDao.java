package techo.apps.isi.uca.com.android_aps.databaseDao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import techo.apps.isi.uca.com.android_aps.models.Experience;

@Dao
public interface ExperienceDao {
    //@Query("SELECT * FROM Experience order by id desc")
    //List<Experience> getAll();
    @Query("SELECT * FROM Experience")
    List<Experience> getAll();

    //@Query("SELECT * FROM Experience WHERE id = :id")
    //Experience loadById(int id);

    @Insert
    void insert(Experience experience);

    @Query("SELECT * FROM Experience s WHERE s.name LIKE :name")
    List<Experience> loadByName(String name);


    @Delete
    void delete(Experience experience);

    @Update
    void update(Experience experience);

    @Query("DELETE FROM Experience")
    void deleteAll();

    //@Query("Select * from Experience order by id DESC LIMIT 1")
    //Experience getLastId();
}
