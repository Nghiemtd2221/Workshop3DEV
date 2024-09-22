package fpoly.anhntph36936.happyfood.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Helper extends SQLiteOpenHelper {

    private static final String DB_NAME = "HappyFood";

//    private static final int DB_VERSION = 8; // Incremented version for the new changes

    private static final int DB_VERSION = 1;

    public DB_Helper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table_sanpham = "CREATE TABLE SanPham (" +
                "maSP INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "anhSP TEXT NOT NULL, " +
                "tenSP TEXT NOT NULL," +
                "phanloaiSP TEXT NOT NULL, " +
                "trongluongSP INTEGER NOT NULL," +
                "giaSP INTEGER NOT NULL," +
                "mota TEXT NOT NULL)";
        db.execSQL(table_sanpham);

        String alterTable = "ALTER TABLE SanPham ADD COLUMN isXoaMem INTEGER DEFAULT 0";
        db.execSQL(alterTable);

        String table_user = "CREATE TABLE User (" +
                "maUser INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "imgSrc text not null," +
                "hoTen text not null," +
                "soDienThoai text not null," +
                "email text not null," +
                "taiKhoan text not null," +
                "matKhau text not null," +
                "loaiTaiKhoan integer not null," +
                "isXoaMem integer not null)";
        db.execSQL(table_user);




        String createHoaDon = "create table HOADON(" +
                "hoaDon_id integer primary key autoincrement," +
                "maUser integer references User(maUser)," +
                "ngayMua date not null," +
                "tongTien integer not null," +
                "diaChi text not null)";
        db.execSQL(createHoaDon);
        String createHoaDonChiTiet = "create table HOADONCHITIET(" +
                "hoaDon_id integer not null," +
                "maSP integer not null," +
                "soLuong integer not null," +
                "trangThaiDonHang integer not null," +
                "trangThaiThanhToan integer not null," +
                "foreign key (hoaDon_id) references HOADON(hoaDon_id)," +
                "foreign key (maSP) references SANPHAM(maSP))";
        db.execSQL(createHoaDonChiTiet);

        String createBinhLuan = "create table BINHLUAN(" +
                "binhLuan_id integer primary key autoincrement," +
                "maUser integer references User(maUser)," +
                "maSP integer references SanPham(maSP)," +
                "noiDung text not null," +
                "thoiGian text not null)";
        db.execSQL(createBinhLuan);
        String createGioHang = "create table GIOHANG(" +
                "maUser integer ," +
                "maSP integer ," +
                "soLuong integer not null, " +
                "trangThaiMua integer not null," +
                "foreign key (maUser) references User(maUser)," +
                "foreign key (maSP)  references SanPham(maSP)," +
                "primary key(maUser, maSP))";
        db.execSQL(createGioHang);
        String createThongBao = "create table THONGBAO(" +
                "thongBao_id integer primary key autoincrement," +
                "maUser integer references User(maUser)," +
                "maSP integer references SanPham(maSP)," +
                "tieuDe text not null," +
                "noiDung text not null," +
                "thoiGian text not null," +
                "isRead integer not null," +
                "loaiThongBao integer not null)";
        db.execSQL(createThongBao);
        db.execSQL("insert into User values" +
                "(1,'https://tse1.mm.bing.net/th?id=OIP.HuRW9_7mC2HcNlRsUBQRTgHaHa&pid=Api&P=0&h=220', 'admin', '0000000000', 'admin@mail.com','admin','123456', 1,0)");

        String data_SanPham = "INSERT INTO SanPham (maSP, anhSP, tenSP, phanloaiSP, trongluongSP, giaSP, mota) VALUES" +
                "(1, 'https://png.pngtree.com/png-clipart/20230427/original/pngtree-hamburger-food-illustration-png-image_9108526.png','Hambuger', 'Đồ ăn', 200, 35000, 'Làm từ thịt bò KoBe')," +
                "(2, 'https://texaschickenvn.com/vnt_upload/product/07_2023/Khoai_tay_chien_co_lon.png', 'Khoai tây chiên', 'Đồ ăn', 200, 25000, 'Khoai tay chiên giòn')," +
                "(3,  'https://cdn-www.vinid.net/2020/04/44cb7516-c%C3%A1ch-l%C3%A0m-g%C3%A0-r%C3%A1n-t%E1%BA%A1i-nh%C3%A0.jpg', 'Cánh gà chiên', 'Đồ ăn', 200, 30000, 'Cánh gà tẩm ướt đủ vị')," +
                "(4, 'https://270cellars.com.au/wp-content/uploads/2017/04/Coke-1.25L-single-bottle.jpg', 'Coca Cola', 'Nước uống', 200, 15000, 'Coca')," +
                "(5, 'https://truongphatdat.com/wp-content/uploads/2018/10/aquafina-500ml-1.jpg', 'Aquafina', 'Nước uống', 200, 15000, 'Nước suối tinh khiết')," +
                "(6, 'https://minhcaumart.vn/media/com_eshop/products/8934588012228%201.jpg', 'Pesi', 'Nước uống', 200, 15000, 'Pesi')";
        db.execSQL(data_SanPham);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            db.execSQL("DROP TABLE IF EXISTS User");
            db.execSQL("DROP TABLE IF EXISTS HOADON");
            db.execSQL("DROP TABLE IF EXISTS HOADONCHITIET");
            db.execSQL("DROP TABLE IF EXISTS BINHLUAN");
            db.execSQL("DROP TABLE IF EXISTS GIOHANG");
            db.execSQL("DROP TABLE IF EXISTS THONGBAO");
            onCreate(db);
        }
        if (newVersion == 8) {
            db.execSQL("ALTER TABLE HOADON ADD COLUMN diaChi TEXT NOT NULL DEFAULT ''");
        }
    }

    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }
}
