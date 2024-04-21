package com.example.huynhanhtien;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng
        db.execSQL("CREATE TABLE answers (id INTEGER PRIMARY KEY AUTOINCREMENT, answer INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xử lý nâng cấp database (nếu cần)
    }

    public void insertAnswer(boolean answer) {
        // Mở kết nối database
        SQLiteDatabase db = getWritableDatabase();

        // Chuẩn bị ContentValues
        ContentValues values = new ContentValues();
        values.put("answer", answer ? 1 : 0); // Chuyển đổi Boolean sang Integer

        // Thực hiện INSERT
        db.insert("answers", null, values);

        // Đóng kết nối database
        db.close();
    }
}