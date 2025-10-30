package com.example.appsebas2;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.inputmethod.InputMethodManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    private TextView textView4, textView5, textView6, textView7;
    private EditText plain_text_input, plain_text_input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        plain_text_input = findViewById(R.id.plain_text_input);
        plain_text_input2 = findViewById(R.id.plain_text_input2);

        Button btnRTA = findViewById(R.id.btnRTA);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        btnRTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                sumar();
                restar();
                producto();
                division();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void sumar(){
        String n1 = plain_text_input.getText().toString().trim();
        String n2 = plain_text_input2.getText().toString().trim();

        if (n1.isEmpty() || n2.isEmpty()){
            Toast.makeText(this, "Favor ingresar ambos numeros.",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            BigDecimal s1 = new BigDecimal(n1);
            BigDecimal s2 = new BigDecimal(n2);
            BigDecimal rta = s1.add(s2);
            textView4.setText("Rta Suma: " + rta.toPlainString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Entrada inválida.", Toast.LENGTH_SHORT).show();
        }
    }
    private void restar(){
        String n1 = plain_text_input.getText().toString().trim();
        String n2 = plain_text_input2.getText().toString().trim();

        if (n1.isEmpty() || n2.isEmpty()){
            Toast.makeText(this, "Favor ingresar ambos numeros.",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            BigDecimal s1 = new BigDecimal(n1);
            BigDecimal s2 = new BigDecimal(n2);
            BigDecimal rta = s1.subtract(s2);
            textView5.setText("Rta Resta: " + rta.toPlainString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Entrada inválida.", Toast.LENGTH_SHORT).show();
        }
    }
    private void division(){
        String n1 = plain_text_input.getText().toString().trim();
        String n2 = plain_text_input2.getText().toString().trim();

        if (n1.isEmpty() || n2.isEmpty()){
            Toast.makeText(this, "Favor ingresar ambos numeros.",Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (n2.equals("0")) {
                Toast.makeText(this, "No se puede dividir entre 0.", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        try {
            BigDecimal s1 = new BigDecimal(n1);
            BigDecimal s2 = new BigDecimal(n2);
            BigDecimal rta = s1.divide(s2, 1, RoundingMode.HALF_UP);
            textView7.setText("Rta Division: " + rta.toPlainString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Operación inválida.", Toast.LENGTH_SHORT).show();
        }
    }
    private void producto(){
        String n1 = plain_text_input.getText().toString().trim();
        String n2 = plain_text_input2.getText().toString().trim();

        if (n1.isEmpty() || n2.isEmpty()){
            Toast.makeText(this, "Favor ingresar ambos numeros.",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            BigDecimal s1 = new BigDecimal(n1);
            BigDecimal s2 = new BigDecimal(n2);
            BigDecimal rta = s1.multiply(s2);
            textView6.setText("Rta Producto: " + rta.toPlainString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Entrada inválida.", Toast.LENGTH_SHORT).show();
        }
    }
    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}