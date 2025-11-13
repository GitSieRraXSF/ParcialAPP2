package com.example.appsebas2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class WidgetActivity extends AppCompatActivity {

    private ImageView imageView2;
    private int[] imagenes = {
            R.drawable.masteryi_42,
            R.drawable.masteryi_89
    };
    private int indice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        imageView2 = findViewById(R.id.imageView2);
        imageView2.setImageResource(imagenes[indice]);
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indice++;
                if (indice >= imagenes.length) {
                    indice = 0;
                }
                imageView2.setImageResource(imagenes[indice]);
            }
        });
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WidgetActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}