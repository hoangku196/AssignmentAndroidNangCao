package com.example.assignment1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignment1.constant.ConstantLopMonHoc;
import com.example.assignment1.database.DatabaseHelper;
import com.example.assignment1.model.LopMonHoc;

public class LopMonHocDAO {
    private static final String TAG = "LopMonHocDAO";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE " + ConstantLopMonHoc.TABLE + " " +
            "(" +
            ConstantLopMonHoc.COLUMN_1 + " Nvarchar(5) PRIMARY KEY NOT NULL, " +
            ConstantLopMonHoc.COLUMN_2 + " Nvarchar(50), " +
            ConstantLopMonHoc.COLUMN_3 + " Nvarchar(50), " +
            ConstantLopMonHoc.COLUMN_4 + " INTEGER, " +
            ConstantLopMonHoc.COLUMN_5 + " INTEGER, " +
            ConstantLopMonHoc.COLUMN_6 + " INTEGER" +
            ")";

    public LopMonHocDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean insert(LopMonHoc lopMH) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantLopMonHoc.COLUMN_1, lopMH.getMaLopMonHoc());
        values.put(ConstantLopMonHoc.COLUMN_2, lopMH.getMaMonHoc());
        values.put(ConstantLopMonHoc.COLUMN_3, lopMH.getLopMonHoc());
        values.put(ConstantLopMonHoc.COLUMN_4, lopMH.getNamHoc());
        values.put(ConstantLopMonHoc.COLUMN_5, lopMH.getHocKi());
        values.put(ConstantLopMonHoc.COLUMN_6, lopMH.getSiSo());
        try {
            if (db.insert(ConstantLopMonHoc.TABLE, null, values) <= 0) {
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

    public boolean update(LopMonHoc lopMH) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantLopMonHoc.COLUMN_1, lopMH.getMaLopMonHoc());
        values.put(ConstantLopMonHoc.COLUMN_2, lopMH.getMaMonHoc());
        values.put(ConstantLopMonHoc.COLUMN_3, lopMH.getLopMonHoc());
        values.put(ConstantLopMonHoc.COLUMN_4, lopMH.getNamHoc());
        values.put(ConstantLopMonHoc.COLUMN_5, lopMH.getHocKi());
        values.put(ConstantLopMonHoc.COLUMN_6, lopMH.getSiSo());

        String whereClause = ConstantLopMonHoc.COLUMN_1 + "=?";
        String[] whereArgs = {lopMH.getMaLopMonHoc()};

        try {
            if (db.update(ConstantLopMonHoc.TABLE, values, whereClause, whereArgs) <= 0) {
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

    public boolean delete(LopMonHoc lopMH) {
        db = dbHelper.getWritableDatabase();
        String whereClause = ConstantLopMonHoc.COLUMN_1 + "=?";
        String[] whereArgs = {lopMH.getMaLopMonHoc()};

        return db.delete(ConstantLopMonHoc.TABLE, whereClause, whereArgs) > 0;
    }
}
