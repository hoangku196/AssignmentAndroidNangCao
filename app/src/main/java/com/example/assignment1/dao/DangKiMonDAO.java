package com.example.assignment1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignment1.constant.ConstantDangKiMon;
import com.example.assignment1.database.DatabaseHelper;
import com.example.assignment1.model.DangKiMon;

public class DangKiMonDAO {
    private static final String TAG = "DangKiMonDAO";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE " + ConstantDangKiMon.TABLE + " " +
            "(" +
            ConstantDangKiMon.COLUMN_1 + " Nvarchar(5) PRIMARY KEY NOT NULL, " +
            ConstantDangKiMon.COLUMN_2 + " Nvarchar(50), " +
            ConstantDangKiMon.COLUMN_3 + " Nvarchar(50)" +
            ")";

    public DangKiMonDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }
    public boolean insert(DangKiMon dkMon) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantDangKiMon.COLUMN_1, dkMon.getMaDangKiMon());
        values.put(ConstantDangKiMon.COLUMN_2, dkMon.getMaSinhVien());
        values.put(ConstantDangKiMon.COLUMN_3, dkMon.getMaLopMonHoc());
        try {
            if (db.insert(ConstantDangKiMon.TABLE, null, values) <= 0) {
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

    public boolean update(DangKiMon dkMon) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantDangKiMon.COLUMN_1, dkMon.getMaDangKiMon());
        values.put(ConstantDangKiMon.COLUMN_2, dkMon.getMaSinhVien());
        values.put(ConstantDangKiMon.COLUMN_3, dkMon.getMaLopMonHoc());

        String whereClause = ConstantDangKiMon.COLUMN_1 + "=?";
        String[] whereArgs = {dkMon.getMaDangKiMon()};

        try {
            if (db.update(ConstantDangKiMon.TABLE, values, whereClause, whereArgs) <= 0) {
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

    public boolean delete(DangKiMon dkMon) {
        db = dbHelper.getWritableDatabase();
        String whereClause = ConstantDangKiMon.COLUMN_1 + "=?";
        String[] whereArgs = {dkMon.getMaDangKiMon()};

        return db.delete(ConstantDangKiMon.TABLE, whereClause, whereArgs) > 0;
    }
}
