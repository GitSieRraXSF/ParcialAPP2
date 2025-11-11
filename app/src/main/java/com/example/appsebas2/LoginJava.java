package com.example.appsebas2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginJava extends AppCompatActivity {
    EditText editTextText4, editTextTextPassword2;
    ListaUsuarios users1 = new ListaUsuarios();

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
                if (users1.equalUser(user, pass)) {
                    Intent intent = new Intent(LoginJava.this, MenuActivity.class);
                    intent.putExtra("Username", user);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginJava.this, "Usuario invalido", Toast.LENGTH_SHORT).show();
                }
                hideKeyboard();
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editTextText4.getText().toString();
                String pass = editTextTextPassword2.getText().toString();
                users1.agregarAlFinal(user, pass);
                Toast.makeText(LoginJava.this, "Usuario Agregado!", Toast.LENGTH_LONG).show();
                hideKeyboard();
            }
        });
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}