package com.example.constraint_layout;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterSuccess extends AppCompatActivity {

    private TextView userName;
    private TextView passWord;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_success);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userName = findViewById(R.id.showUserName);
        passWord = findViewById(R.id.showPassWord);
        email = findViewById(R.id.showEmail);
        TextView btn = findViewById(R.id.btnBackToLogin);

        Intent intent = getIntent();
        String showUserName = intent.getStringExtra("userName_key");
        String showPassWord = intent.getStringExtra("passWord_key");
        String showEmail = intent.getStringExtra("email_key");

        userName.setText(showUserName);
        passWord.setText(showPassWord);
        email.setText(showEmail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterSuccess.this,LoginActivity.class));
            }
        });

    }
}