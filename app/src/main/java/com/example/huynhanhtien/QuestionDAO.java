package com.example.huynhanhtien;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDAO {
    @Query("SELECT * FROM Question")
    List<Question> getAll();

    @Insert
    void insert(Question... questions); // truyền được nhiều data



    @Update
    void updateSinhVien(Question questions);

    @Delete
    void deleteSinhVien(Question questions);
}
