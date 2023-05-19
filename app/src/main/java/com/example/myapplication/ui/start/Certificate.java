package com.example.myapplication.ui.start;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Certificate extends AppCompatActivity {

    Button certificatebutton;

    CheckBox cb_agree, cb_disagree;
    EditText certificateET;
    Boolean agree = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_certificate);

        cb_agree = findViewById(R.id.cb_agree);
        cb_disagree = findViewById(R.id.cb_disagree);
        certificatebutton = findViewById(R.id.btn_certificate_ok);
        certificateET = findViewById(R.id.et_certificate);

        cb_agree.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_agree.isChecked()) {
                    cb_disagree.setChecked(false);
                }
                agree = cb_agree.isChecked();
            }
        }));

        cb_disagree.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_disagree.isChecked()) {
                    cb_agree.setChecked(false);
                    agree = cb_agree.isChecked();
                }
            }
        }));

        certificatebutton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(agree) {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "개인정보처리방침 동의서에 동의해주세요.", Toast.LENGTH_LONG);
                    toast.show();
               }
            }
        }));
    }
}
