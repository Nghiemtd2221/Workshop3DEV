package fpoly.anhntph36936.happyfood.Model;

public class NguoiDung {
    private int nguoiDung_id;
    private String imgSrc;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String taiKhoan;
    private String matKhau;
    private int loaiTaiKhoan;

    private int isXoaMem;

    public NguoiDung(int nguoiDung_id, String imgSrc, String hoTen, String soDienThoai, String email, String taiKhoan, String matKhau, int loaiTaiKhoan, int isXoaMem) {
        this.nguoiDung_id = nguoiDung_id;
        this.imgSrc = imgSrc;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.isXoaMem = isXoaMem;
    }

    public NguoiDung(String imgSrc, String hoTen, String soDienThoai, String email, String taiKhoan, String matKhau, int loaiTaiKhoan, int isXoaMem) {
        this.imgSrc = imgSrc;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.isXoaMem = isXoaMem;
    }

    public NguoiDung() {
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int getIsXoaMem() {
        return isXoaMem;
    }

    public void setIsXoaMem(int isXoaMem) {
        this.isXoaMem = isXoaMem;
    }

    public int getNguoiDung_id() {
        return nguoiDung_id;
    }

    public void setNguoiDung_id(int nguoiDung_id) {
        this.nguoiDung_id = nguoiDung_id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(int loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }
}
