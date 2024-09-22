package fpoly.anhntph36936.happyfood.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


import fpoly.anhntph36936.happyfood.Database.DB_Helper;
import fpoly.anhntph36936.happyfood.Model.NguoiDung;


public class NguoiDungDAO {
    DB_Helper dbHelper;
    SharedPreferences sharedPreferences;

    public NguoiDungDAO(Context context) {
        dbHelper = new DB_Helper(context);
        sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
    }

    public ArrayList<NguoiDung> getDsNguoiDung() {
        ArrayList<NguoiDung> listResult = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from User", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                listResult.add(new NguoiDung(
                        cursor.getInt(0),    //nguoiDung_id
                        cursor.getString(1), //imgSrc
                        cursor.getString(2), //hoTen
                        cursor.getString(3), //soDienThoai
                        cursor.getString(4), //email
                        cursor.getString(5), //taiKhoan
                        cursor.getString(6), //matKhau
                        cursor.getInt(7),    //loaiTaiKhoan
                        cursor.getInt(8)     //isXoaMem
                ));
            } while (cursor.moveToNext());
        }
        return listResult;
    }


    public boolean themTaiKhoan(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("imgSrc", nguoiDung.getImgSrc());
        contentValues.put("hoTen", nguoiDung.getHoTen());
        contentValues.put("soDienThoai", nguoiDung.getSoDienThoai());
        contentValues.put("email", nguoiDung.getEmail());
        contentValues.put("taiKhoan", nguoiDung.getTaiKhoan());
        contentValues.put("matKhau", nguoiDung.getMatKhau());
        contentValues.put("loaiTaiKhoan", nguoiDung.getLoaiTaiKhoan());
        contentValues.put("isXoaMem", nguoiDung.getIsXoaMem());
        long check = sqLiteDatabase.insert("User", null, contentValues);
        return check > 0;
    }

    public boolean themTaiKhoanQL(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("imgSrc", nguoiDung.getImgSrc());
        contentValues.put("hoTen", nguoiDung.getHoTen());
        contentValues.put("soDienThoai", nguoiDung.getSoDienThoai());
        contentValues.put("email", nguoiDung.getEmail());
        contentValues.put("taiKhoan", nguoiDung.getTaiKhoan());
        contentValues.put("matKhau", nguoiDung.getMatKhau());
        contentValues.put("loaiTaiKhoan", nguoiDung.getLoaiTaiKhoan());
        contentValues.put("isXoaMem", nguoiDung.getIsXoaMem());
        long check = sqLiteDatabase.insert("User", null, contentValues);
        return check > 0;
    }
    public int xoaNguoiDungQL(int xoamem) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("isXoaMem", 1);
        return db.update("User", values, "maUser=?", new String[]{String.valueOf(xoamem)});
    }
    public boolean xoaNguoiDung(NguoiDung nguoiDung){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] dk = new String[]{String.valueOf(nguoiDung.getNguoiDung_id())};
        long check = db.delete("User", "maUser=?", dk);
        if (check>0)
            return true;
        return false;
    }

    public int kiemTraDangNhap(String taikhoan, String matkhau) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from User where taikhoan = ? and matkhau = ?", new String[]{taikhoan, matkhau});
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            //Lưu Thông tin
            if (cursor.getInt(8) == 0) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("maUser", cursor.getInt(0));
                editor.putString("imgSrc", cursor.getString(1));
                editor.putString("hoTen", cursor.getString(2));
                editor.putString("soDienThoai", cursor.getString(3));
                editor.putString("email", cursor.getString(4));
                editor.putString("taiKhoan", cursor.getString(5));
                editor.putString("matKhau", cursor.getString(6));
                editor.putInt("loaiTaiKhoan", cursor.getInt(7));
                editor.putInt("isXoaMem", cursor.getInt(8));
                editor.commit();
                return 1; //Dang nhap thanh cong
            } else {
                return -1; //Tai khoan da xoa mem
            }
        }
        return 0; //Tai khoan hoac mat khau khong chinh xac
    }

    public boolean doiMatKhau(int nguoiDung_id, String newPassword) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("matKhau", newPassword);
        long check = sqLiteDatabase.update("User", contentValues, "maUser = ?", new String[]{String.valueOf(nguoiDung_id)});
        return check > 0;
    }

    public boolean thayDoiThongTin(int nguoiDung_id, String imgSrc, String hoTen, String soDienThoai, String email) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("imgSrc", imgSrc);
        contentValues.put("hoTen", hoTen);
        contentValues.put("soDienThoai", soDienThoai);
        contentValues.put("email", email);
        long check = sqLiteDatabase.update("User", contentValues, "maUser = ?", new String[]{String.valueOf(nguoiDung_id)});
        return check > 0;
    }

    public long thayDoiThonTinQL(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("imgSrc",nguoiDung.getImgSrc());
        contentValues.put("hoTen", nguoiDung.getHoTen());
        contentValues.put("soDienThoai", nguoiDung.getSoDienThoai());
        contentValues.put("email", nguoiDung.getEmail());
        contentValues.put("loaiTaiKhoan",nguoiDung.getLoaiTaiKhoan());
        long check = sqLiteDatabase.update("User", contentValues, "maUser = ?", new String[]{String.valueOf(nguoiDung.getNguoiDung_id())});

        // Đóng database sau khi cập nhật
        sqLiteDatabase.close();

        return check;
    };

    public boolean actionIsXoaMem(int nguoiDung_id, int newIsXoaMem) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isXoaMem", newIsXoaMem);
        long check = sqLiteDatabase.update("User", contentValues, "maUser = ?", new String[]{String.valueOf(nguoiDung_id)});
        return check > 0;
    }

    public boolean checkTaiKhoanTonTai(String username) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from User where taiKhoan = ?", new String[]{String.valueOf(username)});
        if (cursor.getCount() != 0) {
            return true; //Tài khoản đã tồn tại
        }
        return false; //Tài khoản chưa tồn tại
    }

    public boolean capNhatThongTinNguoiDung(int nguoiDung_id, String newImgSrc, String newName, String newPhone, String newEmail) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("imgSrc", newImgSrc);
        contentValues.put("hoTen", newName);
        contentValues.put("soDienThoai", newPhone);
        contentValues.put("email", newEmail);
        long check = sqLiteDatabase.update("User",contentValues,"maUser = ?", new String[]{String.valueOf(nguoiDung_id)});
        return check > 0;
    }
}
