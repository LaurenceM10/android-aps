package techo.apps.isi.uca.com.android_aps.databaseDao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import techo.apps.isi.uca.com.android_aps.models.Student;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM Student order by id desc")
    List<Student> getAll();

    @Query("SELECT * FROM Student WHERE id = :id")
    Student loadById(int id);

    @Insert
    void insert(Student student);

    @Query("SELECT * FROM Student s WHERE s.name LIKE :name")
    List<Student> loadBYName(String name);


    @Delete
    void delete(Student student);

    @Update
    void update(Student student);

    @Query("DELETE FROM Student")
    void deleteAll();

    @Query("Select * from Student order by id DESC LIMIT 1")
    Student getLastId();
}
