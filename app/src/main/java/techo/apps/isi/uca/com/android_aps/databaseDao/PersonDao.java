package techo.apps.isi.uca.com.android_aps.databaseDao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import techo.apps.isi.uca.com.android_aps.models.Person;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM Person order by id desc")
    List<Person> getAll();

    @Query("SELECT * FROM Person WHERE id = :id")
    Person loadById(int id);

    @Insert
    void insert(Person person);

    @Query("SELECT * FROM Person a WHERE a.name LIKE :name")
    List<Person> loadBYName(String name);


    @Delete
    void delete(Person person);

    @Update
    void update(Person person);

    @Query("DELETE FROM Person")
    void deleteAll();

    @Query("Select * from Person order by id DESC LIMIT 1")
    Person getLastId();
}
