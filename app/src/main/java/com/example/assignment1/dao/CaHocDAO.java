package com.example.assignment1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignment1.constant.ConstantCaHoc;
import com.example.assignment1.database.DatabaseHelper;
import com.example.assignment1.model.CaHoc;

public class CaHocDAO {
    private static final String TAG = "CaHocDAO";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE " + ConstantCaHoc.TABLE + " " +
            "(" +
            ConstantCaHoc.COLUMN_1 + " INTEGER PRIMARY KEY NOT NULL, " +
            ConstantCaHoc.COLUMN_2 + " Nvarchar(50)" +
            ")";

    public CaHocDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean insert(CaHoc caHoc) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantCaHoc.COLUMN_1, caHoc.getStt());
        values.put(ConstantCaHoc.COLUMN_2, caHoc.getThoiGian());
        try {
            if (db.insert(ConstantCaHoc.TABLE, null, values) <= 0) {
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

    public boolean update(CaHoc caHoc) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantCaHoc.COLUMN_1, caHoc.getStt());
        values.put(ConstantCaHoc.COLUMN_2, caHoc.getThoiGian());

        String whereClause = ConstantCaHoc.COLUMN_1 + "=?";
        String[] whereArgs = {String.valueOf(caHoc.getStt())};

        try {
            if (db.update(ConstantCaHoc.TABLE, values, whereClause, whereArgs) <= 0) {
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

    public boolean delete(CaHoc caHoc) {
        db = dbHelper.getWritableDatabase();
        String whereClause = ConstantCaHoc.COLUMN_1 + "=?";
        String[] whereArgs = {String.valueOf(caHoc.getStt())};

        return db.delete(ConstantCaHoc.TABLE, whereClause, whereArgs) > 0;
    }
}
