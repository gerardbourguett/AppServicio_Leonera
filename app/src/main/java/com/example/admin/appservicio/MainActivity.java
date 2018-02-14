package com.example.admin.appservicio;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    EditText email, pass;

    Button boton;

    Conexion conexion;
    ProgressBar pbbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conexion = new Conexion(); //the class file
        email = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);
        pbbar = findViewById(R.id.progressBar);
        pbbar.setVisibility(View.GONE);
        boton = findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoLogin doLogin = new DoLogin();
                doLogin.execute("");
            }
        });
    }

    public class DoLogin extends AsyncTask<String,String,String> implements com.example.admin.appservicio.DoLogin {
        String z = "";
        Boolean isSuccess = false;

        String user = email.getText().toString();
        String password = pass.getText().toString();

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.GONE);
        }

        @Override
        protected void onPostExecute(String r){
            pbbar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, r ,Toast.LENGTH_LONG).show();

            if(isSuccess){
                Intent i = new Intent (MainActivity.this , HomeActivity.class);
                startActivity(i);
                finish();
            }
        }


        @Override
        protected String doInBackground(String... params) {
            if(user.trim().equals("")|| password.trim().equals("")){
                z = "Por favor ingrese usuario y contraseña";
            } else {
                try {
                    Connection con = conexion.CONN();
                    if(con == null){
                        z = "Error en la conexión con servidor";
                    } else {
                        String query = "select * from user where " + "username='" + user + "' and  pass='" + password + "'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);

                        if(rs.next()){
                            z = "Ingreso satisfactorio";
                        } else {
                            z = "ingreso erróneo en email o contraseña";
                        }
                    }
                } catch (SQLException e) {
                    isSuccess = false;
                    z = "Excepción";
                }
            }
            return null;
        }
    }

}




