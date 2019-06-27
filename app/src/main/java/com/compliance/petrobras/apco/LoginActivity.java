package com.compliance.petrobras.apco;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LoginActivity extends AppCompatActivity {

    private EditText login;
    private EditText senha;
    private Button botaoEntrar;
    private Button linkCadastrar;
    private Button linkRecuperarSenha;

    RelativeLayout really1, really2;
    ImageView imageTitulo;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            really1.setVisibility(View.VISIBLE);
            really2.setVisibility(View.VISIBLE);
            imageTitulo.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.inputLogin);
        senha = findViewById(R.id.inputPassword);
        botaoEntrar = findViewById(R.id.btnEntrar);
        linkCadastrar = findViewById(R.id.linkCadastro);
        linkRecuperarSenha = findViewById(R.id.linkSenha);
        really1 = findViewById(R.id.really1);
        really2 = findViewById(R.id.really2);
        imageTitulo = findViewById(R.id.compliance_titulo);

        handler.postDelayed(runnable, 1000);

        //Seta ação de transição para activity de Recuperar Senha
        linkRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SenhaActivity.class);
                startActivity(i);
            }
        });

        linkCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(i);
            }
        });

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
