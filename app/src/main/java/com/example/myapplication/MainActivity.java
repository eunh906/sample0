package com.example.myapplication;

import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.ui.start.Certificate;
import com.example.myapplication.ui.start.Loading;
import com.example.myapplication.ui.start.Login;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button personalbutton, companybutton, startbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Intent intent = new Intent(this, Loading.class);
        startActivity(intent);


        personalbutton = findViewById(R.id.btn_personal);
        companybutton = findViewById(R.id.btn_company);
        startbutton = findViewById(R.id.btn_start);

        personalbutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(personalbutton.isSelected()) {
                    personalbutton.setSelected(false);
                }
                else {
                    personalbutton.setSelected(true);
                    companybutton.setSelected(false);
                }
            }
        });

        companybutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(companybutton.isSelected()) {
                    companybutton.setSelected(false);
                }
                else {
                    companybutton.setSelected(true);
                    personalbutton.setSelected(false);
                }
            }
        });

        startbutton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(personalbutton.isSelected()) {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                }
                else if(companybutton.isSelected()) {
                    Intent intent = new Intent(getApplicationContext(), Certificate.class);
                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "개인/기관 버튼을 선택해주세요.",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }));
    }
}
