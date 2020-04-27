package com.example.assignment1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assignment1.dao.CaHocDAO;
import com.example.assignment1.dao.DangKiMonDAO;
import com.example.assignment1.dao.KhoaQuanLyDAO;
import com.example.assignment1.dao.LichHocDAO;
import com.example.assignment1.dao.LichThiDAO;
import com.example.assignment1.dao.LopMonHocDAO;
import com.example.assignment1.dao.LopQuanLyDAO;
import com.example.assignment1.dao.MonHocDAO;
import com.example.assignment1.dao.ThongTinSinhVienDAO;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "assignment_template_project_final.db";
    private static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CaHocDAO.CREATE_TABLE);
        db.execSQL(DangKiMonDAO.CREATE_TABLE);
        db.execSQL(KhoaQuanLyDAO.CREATE_TABLE);
        db.execSQL(LichHocDAO.CREATE_TABLE);
        db.execSQL(LichThiDAO.CREATE_TABLE);
        db.execSQL(LopMonHocDAO.CREATE_TABLE);
        db.execSQL(LopQuanLyDAO.CREATE_TABLE);
        db.execSQL(MonHocDAO.CREATE_TABLE);
        db.execSQL(ThongTinSinhVienDAO.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
