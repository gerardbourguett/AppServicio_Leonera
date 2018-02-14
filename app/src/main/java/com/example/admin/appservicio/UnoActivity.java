package com.example.admin.appservicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UnoActivity extends AppCompatActivity {

    Button atras,siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno);

        atras = findViewById(R.id.button3);

        siguiente = findViewById(R.id.button4);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnoActivity.this , HomeActivity.class);
                startActivity(intent);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnoActivity.this , DosActivity.class);
                startActivity(intent);
            }
        });
    }
}
