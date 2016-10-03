package com.example.lconder.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText password;
    Button iniciar;
    Button cancelar;
    String u;
    String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = (Button) findViewById(R.id.Iniciar);
        cancelar = (Button) findViewById(R.id.cancelar);
        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                u = usuario.getText().toString();
                p = password.getText().toString();

                System.out.println("usuario: "+u);
                System.out.println("password: " + p);
                if(u.length() == 0 || p.length() == 0)
                        Toast.makeText(MainActivity.this,"Llena todos los campos...",Toast.LENGTH_SHORT).show();
                else{
                    if(u.equals("Admin") && p.equals("Admin")){
                        Toast.makeText(MainActivity.this,"Contraseña y usuario correctos...",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Inicio.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"Datos incorrectos...",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setText("");
                password.setText("");
            }
        });
    }
}
