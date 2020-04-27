package com.example.assignment1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignment1.constant.ConstantKhoaQuanLy;
import com.example.assignment1.database.DatabaseHelper;
import com.example.assignment1.model.KhoaQuanLy;

public class KhoaQuanLyDAO {

    private static final String TAG = "KhoaQuanLyDAO";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE " + ConstantKhoaQuanLy.TABLE + " " +
            "(" +
            ConstantKhoaQuanLy.COLUMN_1 + " Nvarchar(5) PRIMARY KEY NOT NULL, " +
            ConstantKhoaQuanLy.COLUMN_2 + " Nvarchar(50), " +
            ConstantKhoaQuanLy.COLUMN_3 + " Nvarchar(50)" +
            ")";

    public KhoaQuanLyDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean insert(KhoaQuanLy khoaQL) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantKhoaQuanLy.COLUMN_1, khoaQL.getMaKhoaQuanLy());
        values.put(ConstantKhoaQuanLy.COLUMN_2, khoaQL.getTenNganh());
        values.put(ConstantKhoaQuanLy.COLUMN_3, khoaQL.getTenKhoa());
        try {
            if (db.insert(ConstantKhoaQuanLy.TABLE, null, values) <= 0) {
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

    public boolean update(KhoaQuanLy khoaQL) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantKhoaQuanLy.COLUMN_1, khoaQL.getMaKhoaQuanLy());
        values.put(ConstantKhoaQuanLy.COLUMN_2, khoaQL.getTenNganh());
        values.put(ConstantKhoaQuanLy.COLUMN_3, khoaQL.getTenKhoa());

        String whereClause = ConstantKhoaQuanLy.COLUMN_1 + "=?";
        String[] whereArgs = {khoaQL.getMaKhoaQuanLy()};

        try {
            if (db.update(ConstantKhoaQuanLy.TABLE, values, whereClause, whereArgs) <= 0) {
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

    public boolean delete(KhoaQuanLy khoaQL) {
        db = dbHelper.getWritableDatabase();
        String whereClause = ConstantKhoaQuanLy.COLUMN_1 + "=?";
        String[] whereArgs = {khoaQL.getMaKhoaQuanLy()};

        return db.delete(ConstantKhoaQuanLy.TABLE, whereClause, whereArgs) > 0;
    }
}
