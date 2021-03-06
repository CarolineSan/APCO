package com.compliance.petrobras.apco;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CadastroActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private Spinner spinnerFuncao;
    private Spinner spinnerVinculo;
    private Spinner spinnerSegmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Configura Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cadastre-se");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);
        getSupportActionBar().setElevation(4);

        //Configura Spinner das Funções
        spinnerFuncao = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapterFuncoes = new ArrayAdapter<>(
                CadastroActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.funcoes));
        adapterFuncoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFuncao.setAdapter(adapterFuncoes);

        //Configura Spinner do Vínculo com a petrobras
        spinnerVinculo = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapterVinculo = new ArrayAdapter<>(
                CadastroActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.vinculos));
        adapterFuncoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVinculo.setAdapter(adapterVinculo);

        //Configura Spinner dos Segmentos
        spinnerSegmento = findViewById(R.id.spinner3);
        ArrayAdapter<String> adapterSegmento = new ArrayAdapter<>(
                CadastroActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.segmentos));
        adapterFuncoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSegmento.setAdapter(adapterSegmento);
    }

    public void abrirTermos(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(CadastroActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_termos, null);
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }
}
