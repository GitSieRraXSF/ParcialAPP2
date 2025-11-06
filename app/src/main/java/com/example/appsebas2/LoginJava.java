package com.example.appsebas2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginJava extends AppCompatActivity {

    EditText editTextText4, editTextTextPassword2;
    private final String User = "Sierra1";
    private final String Pass = "Number80";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        editTextText4 = findViewById(R.id.editTextText4);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);

        Button button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editTextText4.getText().toString();
                String pass = editTextTextPassword2.getText().toString();
                if (user.equals(User) && pass.equals(Pass)) {
                    Intent intent = new Intent(LoginJava.this, MenuActivity.class);
                    intent.putExtra("Username", user);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}