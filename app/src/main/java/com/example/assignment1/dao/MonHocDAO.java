package com.example.assignment1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignment1.constant.ConstantMonHoc;
import com.example.assignment1.database.DatabaseHelper;
import com.example.assignment1.model.MonHoc;

public class MonHocDAO {
    private static final String TAG = "MonHocDAO";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE " + ConstantMonHoc.TABLE + " " +
            "(" +
            ConstantMonHoc.COLUMN_1 + " Nvarchar(5) PRIMARY KEY NOT NULL, " +
            ConstantMonHoc.COLUMN_2 + " Nvarchar(50), " +
            ConstantMonHoc.COLUMN_3 + " INTEGER, " +
            ConstantMonHoc.COLUMN_4 + " Nvarchar(50)" +
            ")";

    public MonHocDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean insert(MonHoc monHoc) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantMonHoc.COLUMN_1, monHoc.getMaMonHoc());
        values.put(ConstantMonHoc.COLUMN_2, monHoc.getTenMonHoc());
        values.put(ConstantMonHoc.COLUMN_3, monHoc.getSoTinChi());
        values.put(ConstantMonHoc.COLUMN_4, monHoc.getGhiChu());
        try {
            if (db.insert(ConstantMonHoc.TABLE, null, values) <= 0) {
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

    public boolean update(MonHoc monHoc) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantMonHoc.COLUMN_1, monHoc.getMaMonHoc());
        values.put(ConstantMonHoc.COLUMN_2, monHoc.getTenMonHoc());
        values.put(ConstantMonHoc.COLUMN_3, monHoc.getSoTinChi());
        values.put(ConstantMonHoc.COLUMN_4, monHoc.getGhiChu());

        String whereClause = ConstantMonHoc.COLUMN_1 + "=?";
        String[] whereArgs = {monHoc.getMaMonHoc()};

        try {
            if (db.update(ConstantMonHoc.TABLE, values, whereClause, whereArgs) <= 0) {
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

    public boolean delete(MonHoc monHoc) {
        db = dbHelper.getWritableDatabase();
        String whereClause = ConstantMonHoc.COLUMN_1 + "=?";
        String[] whereArgs = {monHoc.getMaMonHoc()};

        return db.delete(ConstantMonHoc.TABLE, whereClause, whereArgs) > 0;
    }
}
