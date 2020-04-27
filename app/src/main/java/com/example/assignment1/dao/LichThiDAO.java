package com.example.assignment1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignment1.constant.ConstantLichThi;
import com.example.assignment1.database.DatabaseHelper;
import com.example.assignment1.model.LichThi;

public class LichThiDAO {
    private static final String TAG = "LichThiDAO";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE " + ConstantLichThi.TABLE + " " +
            "(" +
            ConstantLichThi.COLUMN_1 + " Nvarchar(5) PRIMARY KEY NOT NULL, " +
            ConstantLichThi.COLUMN_2 + " Nvarchar(50), " +
            ConstantLichThi.COLUMN_3 + " Nvarchar(50), " +
            ConstantLichThi.COLUMN_4 + " Nvarchar(50), " +
            ConstantLichThi.COLUMN_5 + " Nvarchar(50), " +
            ConstantLichThi.COLUMN_6 + " Nvarchar(50)" +
            ")";

    public LichThiDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean insert(LichThi lichThi) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantLichThi.COLUMN_1, lichThi.getMaLichThi());
        values.put(ConstantLichThi.COLUMN_2, lichThi.getSttCaHoc());
        values.put(ConstantLichThi.COLUMN_3, lichThi.getNgayHoc());
        values.put(ConstantLichThi.COLUMN_4, lichThi.getPhong());
        values.put(ConstantLichThi.COLUMN_5, lichThi.getTenGV());
        values.put(ConstantLichThi.COLUMN_6, lichThi.getMaDangKiMon());
        try {
            if (db.insert(ConstantLichThi.TABLE, null, values) <= 0) {
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

    public boolean update(LichThi lichThi) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantLichThi.COLUMN_1, lichThi.getMaLichThi());
        values.put(ConstantLichThi.COLUMN_2, lichThi.getSttCaHoc());
        values.put(ConstantLichThi.COLUMN_3, lichThi.getNgayHoc());
        values.put(ConstantLichThi.COLUMN_4, lichThi.getPhong());
        values.put(ConstantLichThi.COLUMN_5, lichThi.getTenGV());
        values.put(ConstantLichThi.COLUMN_6, lichThi.getMaDangKiMon());

        String whereClause = ConstantLichThi.COLUMN_1 + "=?";
        String[] whereArgs = {lichThi.getMaLichThi()};

        try {
            if (db.update(ConstantLichThi.TABLE, values, whereClause, whereArgs) <= 0) {
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

    public boolean delete(LichThi lichThi) {
        db = dbHelper.getWritableDatabase();
        String whereClause = ConstantLichThi.COLUMN_1 + "=?";
        String[] whereArgs = {lichThi.getMaLichThi()};

        return db.delete(ConstantLichThi.TABLE, whereClause, whereArgs) > 0;
    }
}
