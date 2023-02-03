package com.hyunsungkr.registerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editPassword;
    EditText editpassword2;
    Button button;

    Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editEmail = findViewById(R.id.editEmail);
         editPassword = findViewById(R.id.editPassword);
         editpassword2 = findViewById(R.id.editPassword2);
         button = findViewById(R.id.button);
         btnLogin = findViewById(R.id.btnLogin);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = editEmail.getText().toString().trim();
                if (Email.contains("@") == false) {
                    Toast.makeText(getApplicationContext(), "이메일을 바르게 입력하세요.", Toast.LENGTH_SHORT).show();

                    return;
                }
                String password = editPassword.getText().toString().trim();
                String password2 = editpassword2.getText().toString().trim();

                if (password.length() < 6 || password.length() > 12) {
                    Toast.makeText(getApplicationContext(), "비밀번호 길이를 확인하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

//                if (password.compareTo(ckpassword)!=0){
//                    Toast.makeText(getApplicationContext(),"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
//                }

                // 위의 방법보다 더 쉬운방법
                if (password.equals(editpassword2) == false) {
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }



                // 정상적으로 동작한 코드는 아래서 처리
                Intent intent = new Intent(MainActivity.this, AvatarActivity.class);
                intent.putExtra("email", Email);
                intent.putExtra("password", password);

                startActivity(intent);

                finish();


            }

        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);


                startActivity(intent);
                finish();


            }
        });


    }
}