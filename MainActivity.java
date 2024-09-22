package fpoly.anhntph36936.happyfood;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer_adm;
    Toolbar toolbar_adm;
    NavigationView navi_adm;
    private Fragment fragment;
    private DrawerLayout drawerLayout_frame4;
    private NavigationView navigationView_frame4;

    ActionBarDrawerToggle drawerToggle;
    private ImageView imgAvatar_header, imgMuiTen_header;
    private FragmentManager fragmentManager;
    int loaiTaiKhoan;
    private TextView tvName_header, tvPhoneNumber_header, tvEmail_header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer_adm = findViewById(R.id.drawerLayout_frame4);
        toolbar_adm = findViewById(R.id.toolbar_frame4);
        navi_adm = findViewById(R.id.navigationView_frame4);
        View headerLayout = navi_adm.getHeaderView(0);
        imgAvatar_header = headerLayout.findViewById(R.id.imgAvatar_header);
        imgMuiTen_header = headerLayout.findViewById(R.id.imgMuiTen_header);
        tvName_header = headerLayout.findViewById(R.id.tvName_header);
        tvPhoneNumber_header = headerLayout.findViewById(R.id.tvPhoneNumber_header);
        tvEmail_header = headerLayout.findViewById(R.id.tvEmail_header);

//        setSupportActionBar(toolbar_adm);
//        getSupportActionBar().setTitle("Happy Food");
//        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
//        loaiTaiKhoan = sharedPreferences.getInt("loaiTaiKhoan",-1);
//
//
//
//        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawer_adm, toolbar_adm, R.string.open, R.string.close);
//        drawerToggle.setDrawerIndicatorEnabled(true);
//        drawerToggle.syncState();
//        drawer_adm.addDrawerListener(drawerToggle);
//
//        fragmentManager = getSupportFragmentManager();
////        fragment = new HomeFragment();
//        fragmentManager.beginTransaction().replace(R.id.frameLayout_frame4, fragment).commit();
    }
}