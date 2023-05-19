package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.HomeMain2Binding;
import com.example.myapplication.ui.home.PostData;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;


public class HomeMainActivity extends AppCompatActivity {
    private HomeMain2Binding binding;
    Bitmap bitmap;
    String imagePath, tag, deduction, getTitle, nickname;
    Date date;
    String user;
    private ArrayList<PostData> homeArrayList = new ArrayList<>();
    private static final int PERMISSION_REQUEST_CODE = 100;
    Button btn_complete;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = HomeMain2Binding.inflate( getLayoutInflater() );
        setContentView( binding.getRoot() );

        checkPermission();
        NavController navController1 = Navigation.findNavController (this, R.id.nav_host_fragment_activity_main);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.navigation_match, R.id.navigation_chat, R.id.navigation_inf )
                        .build();
        Toolbar toolbar = findViewById(R.id.toolbar2);
        NavigationUI.setupWithNavController(
                toolbar, navController1, appBarConfiguration);
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment_activity_main );
        NavigationUI.setupWithNavController( binding.navView, navController );
        btn_complete = findViewById( R.id.btn_write_complete );
        RelativeLayout rlayout_home = findViewById( R.id.rlayout_home );


        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                switch (Objects.requireNonNull(navController.getCurrentDestination()).getId()) {
                    case R.id.navigation_match:
                        rlayout_home.setVisibility(View.VISIBLE);
                        btn_complete.setVisibility(View.GONE);
                        break;
                    case R.id.navigation_chat:
                        rlayout_home.setVisibility(View.GONE);
                        btn_complete.setVisibility(View.GONE);
                        break;
                    case R.id.navigation_inf:
                        rlayout_home.setVisibility(View.GONE);
                        btn_complete.setVisibility(View.GONE);
                        break;
                    case R.id.writingFragment:
                        rlayout_home.setVisibility(View.GONE);
                        btn_complete.setVisibility(View.VISIBLE);
                        break;
                    case R.id.homeitemFragment:
                        rlayout_home.setVisibility(View.GONE);
                        break;
                }
            }
        });

    }
    private void checkPermission() {

        if (ContextCompat.checkSelfPermission( this, android.Manifest.permission.READ_EXTERNAL_STORAGE ) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions( this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE );
        }
    }

    public Button getButton(){
        return btn_complete;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return onSupportNavigateUp();
    }
    private Bitmap resize(Bitmap bm) {
        Configuration config = getResources().getConfiguration();
        if (config.smallestScreenWidthDp >= 800)
            bm = Bitmap.createScaledBitmap( bm, 240, 220, true );
        else if (config.smallestScreenWidthDp >= 600)
            bm = Bitmap.createScaledBitmap( bm, 200, 180, true );
        else if (config.smallestScreenWidthDp >= 400)
            bm = Bitmap.createScaledBitmap( bm, 160, 140, true );
        else if (config.smallestScreenWidthDp >= 360)
            bm = Bitmap.createScaledBitmap( bm, 120, 100, true );
        else
            bm = Bitmap.createScaledBitmap( bm, 100, 80, true );
        return bm;
    }
}
