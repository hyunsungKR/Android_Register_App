package com.hyunsungkr.registerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AvatarActivity extends AppCompatActivity {

    ImageView imgAvata;
    Button btnRabbit;
    Button btnTurtle;
    Button btnOk;
    String email;
    String password;

    int avataType = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);
        imgAvata = findViewById(R.id.imgAvatar);
        btnRabbit = findViewById(R.id.btnRabbit);
        btnTurtle = findViewById(R.id.btnTurtle);
        btnOk = findViewById(R.id.btnOk);

        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");

        btnRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAvata.setImageResource(R.drawable.rabbit);
                avataType = 0;
            }
        });
        btnTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAvata.setImageResource(R.drawable.turtlechar);
                avataType = 1;
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(avataType==-1){
                    Toast.makeText(AvatarActivity.this,"아바타를 선택해주세요.",Toast.LENGTH_SHORT).show();

                    return;
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(AvatarActivity.this);
                builder.setTitle("회원가입 완료");
                builder.setMessage("완료하시겠습니까?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // 이메일, 패스워드, 아바타 타입을
                        // SharedPrefrence에 저장한다.
                        SharedPreferences sp = getSharedPreferences("RegisterApp_sp",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("email",email);
                        editor.putString("password",password);
                        editor.putInt("avataType",avataType);
                        editor.apply();



                        // Welcome Activity를 띄운다.
                        Intent intent = new Intent(AvatarActivity.this,WelcomeActivity.class);
                        intent.putExtra("email",email);
                        intent.putExtra("type","Register");
                        startActivity(intent);
                        finish();

                    }
                });
                builder.show();

            }
        });
    }
}