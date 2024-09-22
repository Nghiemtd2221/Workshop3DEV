package fpoly.anhntph36936.happyfood.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import fpoly.anhntph36936.happyfood.Dao.NguoiDungDAO;
import fpoly.anhntph36936.happyfood.MainActivity;
import fpoly.anhntph36936.happyfood.R;

public class Main_DangNhap extends AppCompatActivity {
    private EditText edtUsername_frame2, edtPassword_frame2;
    private ImageView imgShowPassword_frame2;
    private CheckBox chkRememberPassword_frame2;
    private Button btnNext_frame2;
    private TextView tvSignIn_frame2;
    public boolean isVisiblePassword = false;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dang_nhap);
        sharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE);
        edtUsername_frame2 = findViewById(R.id.edtUsername_frame2);
        edtPassword_frame2 = findViewById(R.id.edtPassword_frame2);
        imgShowPassword_frame2 = findViewById(R.id.imgShowPassword_frame2);
        chkRememberPassword_frame2 = findViewById(R.id.chkRememberPassword_frame2);
        btnNext_frame2 = findViewById(R.id.btnNext_frame2);
        tvSignIn_frame2 = findViewById(R.id.tvSignIn_frame2);

        setTaiKhoan();

        btnNext_frame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kiemTraDangNhap();
            }
        });

        imgShowPassword_frame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPassword();
            }
        });

        tvSignIn_frame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_DangNhap.this, Main_DangKy.class);
                startActivity(intent);
            }
        });
    }
    public void kiemTraDangNhap() {
        String taikhoan = edtUsername_frame2.getText().toString();
        String matkhau = edtPassword_frame2.getText().toString();
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(this);

        if (taikhoan.equals("") || matkhau.equals("")) {
            Toast.makeText(this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
        } else {
            int check = nguoiDungDAO.kiemTraDangNhap(taikhoan, matkhau);
            switch (check){
                case 0:
                    Toast.makeText(this, "Tài khoản và mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    saveTaiKhoan(taikhoan, matkhau);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                    break;
                case -1:
                    Toast.makeText(this, "Tài khoản này hiện không khả dụng", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    public void setTaiKhoan() {
        String getTaiKhoan = sharedPreferences.getString("taikhoan", "");
        String getMatKhau = sharedPreferences.getString("matkhau", "");
        if (!getTaiKhoan.equalsIgnoreCase("")) {
            edtUsername_frame2.setText(getTaiKhoan);
            if (!getMatKhau.equalsIgnoreCase("")) {
                edtPassword_frame2.setText(getMatKhau);
                chkRememberPassword_frame2.setChecked(true);
            } else {
                chkRememberPassword_frame2.setChecked(false);
            }
        }
    }

    public void saveTaiKhoan(String taikhoan, String matkhau) {
        editor = sharedPreferences.edit();
        editor.putString("taikhoan", taikhoan);
        if (chkRememberPassword_frame2.isChecked()) {
            editor.putString("matkhau", matkhau);
        } else {
            editor.remove("matkhau");
        }
        editor.commit();
    }

    public void showPassword() {
        if (isVisiblePassword) {
            // Ẩn password
            edtPassword_frame2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            isVisiblePassword = false;
        } else {
            // Hiện password
            edtPassword_frame2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            isVisiblePassword = true;
        }
        // Di chuyển con trỏ về cuối chuỗi
        edtPassword_frame2.setSelection(edtPassword_frame2.getText().length());
    }
}