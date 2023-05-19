package com.example.myapplication.ui.start;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.HomeMainActivity;
import com.example.myapplication.R;

public class Login extends AppCompatActivity {

    Button logingoogle, loginnaver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login);

        logingoogle = findViewById(R.id.btn_login_google);
        loginnaver = findViewById(R.id.btn_login_naver);

        logingoogle.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), HomeMainActivity.class);
                startActivity(intent);
            }
        }));

        loginnaver.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), HomeMainActivity.class);
                startActivity(intent);
            }
        }));
    }
}
