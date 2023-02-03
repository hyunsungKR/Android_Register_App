package com.hyunsungkr.registerapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    private static final String SP_NAME = "register_app";
    EditText editLoginEmail;
    EditText editLoginPassword;
    Button btnLogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        editLoginEmail = findViewById(R.id.editLoginEmail);
        editLoginPassword = findViewById(R.id.editLoginPassword);
        btnLogin2 = findViewById(R.id.btnLogin2);

        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 유저가 입력한 이메일과 패스워드
                String email = editLoginEmail.getText().toString().trim();
                String password = editLoginPassword.getText().toString().trim();

                // 저장되어있던 이메일과 패스워드를 가져온다.
                SharedPreferences sp = getSharedPreferences("RegisterApp_sp",MODE_PRIVATE);
                String savedEmail=sp.getString("email","");
                String savedPassword = sp.getString("password","");

                // 이메일과 패스워드가 일치하는지 확인하는 코드
                if(email.equals(savedEmail) == false || password.equals(savedPassword) == false){
                    Toast.makeText(UserActivity.this, "이메일이나 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // todo : Welcome Activty를 띄운다.
                Intent intent = new Intent(UserActivity.this,WelcomeActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("type","Login");
                startActivity(intent);
                finish();




            }
        });




    }
}