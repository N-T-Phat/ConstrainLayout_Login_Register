package com.example.constraint_layout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private EditText userName;
    private EditText passWord;
    private EditText email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView btn = findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });


        userName = findViewById(R.id.inputUsernameRegister);
        passWord = findViewById(R.id.inputPassword);
        email = findViewById(R.id.inputEmail);
        TextView btn_Register = findViewById(R.id.btnRegister);
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = userName.getText().toString();
                String matKha = passWord.getText().toString();
                String mail = email.getText().toString();
                Intent intent = new Intent(RegisterActivity.this,RegisterSuccess.class);
                intent.putExtra("userName_key",ten);
                intent.putExtra("passWord_key",matKha);
                intent.putExtra("email_key",mail);
                startActivity(intent);
            }
        });
    }
}