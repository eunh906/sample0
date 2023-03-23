package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.myapplication.databinding.HomeMain2Binding;


public class HomeMainActivity extends AppCompatActivity {
    private HomeMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = HomeMain2Binding.inflate( getLayoutInflater() );
        setContentView( binding.getRoot() );

        NavController navController1 = Navigation.findNavController (this, R.id.nav_host_fragment_activity_main);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.navigation_match, R.id.navigation_chat, R.id.navigation_inf )
                        .build();
        Toolbar toolbar = findViewById(R.id.toolbar2);
        NavigationUI.setupWithNavController(
                toolbar, navController1, appBarConfiguration);
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment_activity_main );
        NavigationUI.setupWithNavController( binding.navView, navController );

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return onSupportNavigateUp();
    }

}
