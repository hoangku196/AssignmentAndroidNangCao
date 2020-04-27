package com.example.assignment1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignment1.constant.ConstantLopQuanLy;
import com.example.assignment1.database.DatabaseHelper;
import com.example.assignment1.model.LopQuanLy;

public class LopQuanLyDAO {
    private static final String TAG = "LopQuanLyDAO";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE " + ConstantLopQuanLy.TABLE + " " +
            "(" +
            ConstantLopQuanLy.COLUMN_1 + " Nvarchar(5) PRIMARY KEY NOT NULL, " +
            ConstantLopQuanLy.COLUMN_2 + " Nvarchar(50), " +
            ConstantLopQuanLy.COLUMN_3 + " Nvarchar(50), " +
            ConstantLopQuanLy.COLUMN_4 + " Nvarchar(50), " +
            ConstantLopQuanLy.COLUMN_5 + " INTEGER, " +
            ConstantLopQuanLy.COLUMN_6 + " INTEGER" +
            ")";

    public LopQuanLyDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean insert(LopQuanLy lopQL) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantLopQuanLy.COLUMN_1, lopQL.getMaLopQuanLy());
        values.put(ConstantLopQuanLy.COLUMN_2, lopQL.getMaNganhQuanLy());
        values.put(ConstantLopQuanLy.COLUMN_3, lopQL.getLopQuanLy());
        values.put(ConstantLopQuanLy.COLUMN_4, lopQL.getKhoaHoc());
        values.put(ConstantLopQuanLy.COLUMN_5, lopQL.getNamNhapHoc());
        values.put(ConstantLopQuanLy.COLUMN_6, lopQL.getSiSo());
        try {
            if (db.insert(ConstantLopQuanLy.TABLE, null, values) <= 0) {
                db.close();
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            db.close();
            return false;
        }
        db.close();
        return true;
    }

    public boolean update(LopQuanLy lopQL) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantLopQuanLy.COLUMN_1, lopQL.getMaLopQuanLy());
        values.put(ConstantLopQuanLy.COLUMN_2, lopQL.getMaNganhQuanLy());
        values.put(ConstantLopQuanLy.COLUMN_3, lopQL.getLopQuanLy());
        values.put(ConstantLopQuanLy.COLUMN_4, lopQL.getKhoaHoc());
        values.put(ConstantLopQuanLy.COLUMN_5, lopQL.getNamNhapHoc());
        values.put(ConstantLopQuanLy.COLUMN_6, lopQL.getSiSo());

        String whereClause = ConstantLopQuanLy.COLUMN_1 + "=?";
        String[] whereArgs = {lopQL.getMaLopQuanLy()};

        try {
            if (db.update(ConstantLopQuanLy.TABLE, values, whereClause, whereArgs) <= 0) {
                db.close();
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            db.close();
            return false;
        }
        db.close();
        return true;
    }

    public boolean delete(LopQuanLy lopQL) {
        db = dbHelper.getWritableDatabase();
        String whereClause = ConstantLopQuanLy.COLUMN_1 + "=?";
        String[] whereArgs = {lopQL.getMaLopQuanLy()};

        return db.delete(ConstantLopQuanLy.TABLE, whereClause, whereArgs) > 0;
    }
}
