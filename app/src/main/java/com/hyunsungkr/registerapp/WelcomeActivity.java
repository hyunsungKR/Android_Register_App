package com.hyunsungkr.registerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView txtEmail;
    TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtEmail = findViewById(R.id.txtEmail);
        txtMsg = findViewById(R.id.txtMsg);

        String email=getIntent().getStringExtra("email");
        String type = getIntent().getStringExtra("type");


        txtEmail.setText(email + "님 안녕하세요.");
        if(type.equals("Login")){
            txtMsg.setText("메인 화면입니다.");
        }



    }
}