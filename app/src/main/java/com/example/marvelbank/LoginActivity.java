package com.example.marvelbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btn;
    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.button);
        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String u = usuario.getText().toString();
                String s = senha.getText().toString();
                if (u.equals(s) && !u.isEmpty()) {
                    Intent i = new Intent(LoginActivity.this, AbstractActivity.class);
                    Usuario user = new Usuario(u, s);
                    i.putExtra("obj_usuario", user);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Erro! Usuário / senha são diferentes ou em branco!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}