package com.example.assignment1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignment1.constant.ConstantLichHoc;
import com.example.assignment1.database.DatabaseHelper;
import com.example.assignment1.model.LichHoc;

public class LichHocDAO {
    private static final String TAG = "LichHocDAO";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE " + ConstantLichHoc.TABLE + " " +
            "(" +
            ConstantLichHoc.COLUMN_1 + " Nvarchar(5) PRIMARY KEY NOT NULL, " +
            ConstantLichHoc.COLUMN_2 + " Nvarchar(50), " +
            ConstantLichHoc.COLUMN_3 + " Nvarchar(50), " +
            ConstantLichHoc.COLUMN_4 + " Nvarchar(50), " +
            ConstantLichHoc.COLUMN_5 + " Nvarchar(50), " +
            ConstantLichHoc.COLUMN_6 + " Nvarchar(50)" +
            ")";

    public LichHocDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean insert(LichHoc lichHoc) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantLichHoc.COLUMN_1, lichHoc.getMaLichHoc());
        values.put(ConstantLichHoc.COLUMN_2, lichHoc.getSttCaHoc());
        values.put(ConstantLichHoc.COLUMN_3, lichHoc.getNgayHoc());
        values.put(ConstantLichHoc.COLUMN_4, lichHoc.getPhong());
        values.put(ConstantLichHoc.COLUMN_5, lichHoc.getTenGV());
        values.put(ConstantLichHoc.COLUMN_6, lichHoc.getMaDangKiMon());
        try {
            if (db.insert(ConstantLichHoc.TABLE, null, values) <= 0) {
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

    public boolean update(LichHoc lichHoc) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantLichHoc.COLUMN_1, lichHoc.getMaLichHoc());
        values.put(ConstantLichHoc.COLUMN_2, lichHoc.getSttCaHoc());
        values.put(ConstantLichHoc.COLUMN_3, lichHoc.getNgayHoc());
        values.put(ConstantLichHoc.COLUMN_4, lichHoc.getPhong());
        values.put(ConstantLichHoc.COLUMN_5, lichHoc.getTenGV());
        values.put(ConstantLichHoc.COLUMN_6, lichHoc.getMaDangKiMon());

        String whereClause = ConstantLichHoc.COLUMN_1 + "=?";
        String[] whereArgs = {lichHoc.getMaLichHoc()};

        try {
            if (db.update(ConstantLichHoc.TABLE, values, whereClause, whereArgs) <= 0) {
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

    public boolean delete(LichHoc lichHoc) {
        db = dbHelper.getWritableDatabase();
        String whereClause = ConstantLichHoc.COLUMN_1 + "=?";
        String[] whereArgs = {lichHoc.getMaLichHoc()};

        return db.delete(ConstantLichHoc.TABLE, whereClause, whereArgs) > 0;
    }
}
