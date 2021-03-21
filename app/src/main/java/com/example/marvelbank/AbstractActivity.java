package com.example.marvelbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AbstractActivity extends AppCompatActivity {

    private TextView usuario;
    private Button splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        usuario = findViewById(R.id.usuario_logado);
        splash = findViewById(R.id.splash);

        Usuario user = getIntent().getParcelableExtra("obj_usuario");
        usuario.setText("Usuário: " + user.getUsuario() + " Senha: " + user.getSenha());

        splash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AbstractActivity.this, MainActivity.class));
                finishAffinity();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}