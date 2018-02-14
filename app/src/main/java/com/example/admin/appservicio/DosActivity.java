package com.example.admin.appservicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DosActivity extends AppCompatActivity {

    Button atras, siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        atras = findViewById(R.id.button3);

        siguiente = findViewById(R.id.button4);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DosActivity.this , UnoActivity.class);
                startActivity(intent);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DosActivity.this , TresActivity.class);
                startActivity(intent);
            }
        });
    }
}
