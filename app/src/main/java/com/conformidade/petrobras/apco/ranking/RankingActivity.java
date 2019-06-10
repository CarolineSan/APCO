package com.conformidade.petrobras.apco.ranking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.conformidade.petrobras.apco.R;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private RecyclerView recyclerUser;
    private RecyclerView recyclerTop;
    private MyAdapterRanking adapterUser;
    private MyAdapterRanking adapterTop;
    private List<RecyclerRanking> listaUser;
    private List<RecyclerRanking> listaTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        //Configura Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ranking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);
        getSupportActionBar().setElevation(4);

        //Instanciando Variáveis
        recyclerUser = findViewById(R.id.recyclerRankingUser);
        recyclerUser.setLayoutManager(new LinearLayoutManager(this));
        recyclerTop = findViewById(R.id.recyclerRankingTop);
        recyclerTop.setLayoutManager(new LinearLayoutManager(this));

        listaUser = new ArrayList<>();
        listaTop = new ArrayList<>();

        for(int i = 0; i<1; i++) {
            listaUser.add(new RecyclerRanking("Caroline Oliveira", "15", "2250"));
        }

        for(int i = 1; i<=10; i++) {
            listaTop.add(new RecyclerRanking("Caroline Oliveira", String.valueOf(i), String.valueOf(10251 - i)));
        }

        adapterUser = new MyAdapterRanking(listaUser);
        recyclerUser.setAdapter(adapterUser);

        adapterTop = new MyAdapterRanking(listaTop);
        recyclerTop.setAdapter(adapterTop);

    }
}
