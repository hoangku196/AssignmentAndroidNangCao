package com.example.assignment1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.assignment1.constant.ConstantThongTinSinhVien;
import com.example.assignment1.database.DatabaseHelper;
import com.example.assignment1.model.ThongTinSinhVien;

public class ThongTinSinhVienDAO {
    private static final String TAG = "ThongTinSinhVienDAO";
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE " + ConstantThongTinSinhVien.TABLE + " " +
            "(" +
            ConstantThongTinSinhVien.COLUMN_1 + " Nvarchar(5) PRIMARY KEY NOT NULL, " +
            ConstantThongTinSinhVien.COLUMN_2 + " Nvarchar(50), " +
            ConstantThongTinSinhVien.COLUMN_3 + " Nvarchar(50), " +
            ConstantThongTinSinhVien.COLUMN_4 + " Nvarchar(50), " +
            ConstantThongTinSinhVien.COLUMN_5 + " Nvarchar(50), " +
            ConstantThongTinSinhVien.COLUMN_6 + " Nvarchar(50), " +
            ConstantThongTinSinhVien.COLUMN_7 + " Nvarchar(50), " +
            ConstantThongTinSinhVien.COLUMN_8 + " Nvarchar(50)" +
            ")";

    private String maSinhVien;
    private String maLopQuanLy;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String queQuan;
    private String ghiChu;
    private String email;

    public ThongTinSinhVienDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean insert(ThongTinSinhVien ttsv) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantThongTinSinhVien.COLUMN_1, ttsv.getMaSinhVien());
        values.put(ConstantThongTinSinhVien.COLUMN_2, ttsv.getMaLopQuanLy());
        values.put(ConstantThongTinSinhVien.COLUMN_3, ttsv.getHoTen());
        values.put(ConstantThongTinSinhVien.COLUMN_4, ttsv.getNgaySinh());
        values.put(ConstantThongTinSinhVien.COLUMN_5, ttsv.getGioiTinh());
        values.put(ConstantThongTinSinhVien.COLUMN_6, ttsv.getQueQuan());
        values.put(ConstantThongTinSinhVien.COLUMN_7, ttsv.getGhiChu());
        values.put(ConstantThongTinSinhVien.COLUMN_8, ttsv.getEmail());
        try {
            if (db.insert(ConstantThongTinSinhVien.TABLE, null, values) <= 0) {
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

    public boolean update(ThongTinSinhVien ttsv) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantThongTinSinhVien.COLUMN_1, ttsv.getMaSinhVien());
        values.put(ConstantThongTinSinhVien.COLUMN_2, ttsv.getMaLopQuanLy());
        values.put(ConstantThongTinSinhVien.COLUMN_3, ttsv.getHoTen());
        values.put(ConstantThongTinSinhVien.COLUMN_4, ttsv.getNgaySinh());
        values.put(ConstantThongTinSinhVien.COLUMN_5, ttsv.getGioiTinh());
        values.put(ConstantThongTinSinhVien.COLUMN_6, ttsv.getQueQuan());
        values.put(ConstantThongTinSinhVien.COLUMN_7, ttsv.getGhiChu());
        values.put(ConstantThongTinSinhVien.COLUMN_8, ttsv.getEmail());

        String whereClause = ConstantThongTinSinhVien.COLUMN_1 + "=?";
        String[] whereArgs = {ttsv.getMaSinhVien()};

        try {
            if (db.update(ConstantThongTinSinhVien.TABLE, values, whereClause, whereArgs) <= 0) {
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

    public boolean delete(ThongTinSinhVien ttsv) {
        db = dbHelper.getWritableDatabase();
        String whereClause = ConstantThongTinSinhVien.COLUMN_1 + "=?";
        String[] whereArgs = {ttsv.getMaSinhVien()};

        return db.delete(ConstantThongTinSinhVien.TABLE, whereClause, whereArgs) > 0;
    }
}
