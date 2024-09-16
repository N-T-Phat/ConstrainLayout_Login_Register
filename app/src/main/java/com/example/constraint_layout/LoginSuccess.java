package com.example.constraint_layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.charset.StandardCharsets;

public class LoginSuccess extends AppCompatActivity {

    private TextView userName;
    private TextView passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_success);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        userName = findViewById(R.id.showUserName);
        passWord = findViewById(R.id.showPassWord);
        Button btn = findViewById(R.id.btnBackToLogin);

        //Nhap du lieu
        Intent intent = getIntent();
        String showUserName = intent.getStringExtra("userName_key");
        String showPassWord = intent.getStringExtra("passWord_key");
        //Hien thi du lieu trong textview moi
        userName.setText(showUserName);
        passWord.setText(showPassWord);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginSuccess.this, LoginActivity.class));
            }
        });
    }
}