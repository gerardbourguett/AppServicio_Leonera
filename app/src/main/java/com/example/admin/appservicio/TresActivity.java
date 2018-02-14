package com.example.admin.appservicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TresActivity extends AppCompatActivity {

    Button atras, siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres);

        atras = findViewById(R.id.button3);

        siguiente = findViewById(R.id.button4);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TresActivity.this , DosActivity.class);
                startActivity(intent);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TresActivity.this , FinalActivity.class);
                startActivity(intent);
            }
        });
    }
}
