package com.conformidade.petrobras.apco;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText login;
    private TextInputEditText senha;
    private Button botaoEntrar;
    private TextView linkCadastrar;
    private TextView linkRecuperarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.inputLogin);
        senha = findViewById(R.id.inputPassword);
        botaoEntrar = findViewById(R.id.btnEntrar);
        linkCadastrar = findViewById(R.id.linkCadastro);
        linkRecuperarSenha = findViewById(R.id.linkSenha);

        //Seta ação de transição para activity de Recuperar Senha
        linkRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SenhaActivity.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.)
                startActivity(i);
            }
        });

    }
}
