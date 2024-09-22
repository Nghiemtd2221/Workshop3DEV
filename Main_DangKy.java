package fpoly.anhntph36936.happyfood.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import fpoly.anhntph36936.happyfood.R;

public class Main_DangKy extends AppCompatActivity {
    private ImageView imgAvatar_frame3, imv_back;
    private EditText edtName_frame3, edtPhoneNumber_frame3, edtEmail_frame3, edtUsername_frame3, edtPassword_frame3;
    private Button btnSignUp_frame3;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dang_ky);
        imgAvatar_frame3 = findViewById(R.id.imgAvatar_frame3);
        imv_back = findViewById(R.id.imv_back);
        edtName_frame3 = findViewById(R.id.edtName_frame3);
        edtPhoneNumber_frame3 = findViewById(R.id.edtPhoneNumber_frame3);
        edtEmail_frame3 = findViewById(R.id.edtEmail_frame3);
        edtUsername_frame3 = findViewById(R.id.edtUsername_frame3);
        edtPassword_frame3 = findViewById(R.id.edtPassword_frame3);
        btnSignUp_frame3 = findViewById(R.id.btnSignUp_frame3);

        imv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_DangKy.this, Main_DangNhap.class));
            }
        });
    }
}