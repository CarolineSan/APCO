package com.compliance.petrobras.apco;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.compliance.petrobras.apco.categoria.CategoriaActivity;
import com.compliance.petrobras.apco.helper.MyAdapterItem;
import com.compliance.petrobras.apco.model.RecyclerItem;
import com.compliance.petrobras.apco.ranking.RankingActivity;

import java.util.ArrayList;
import java.util.List;

import static com.compliance.petrobras.apco.helper.Constant.POST_PESQUISA;
import static com.compliance.petrobras.apco.helper.Constant.POST_QUIZ;
import static com.compliance.petrobras.apco.helper.Constant.POST_TEXTO;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private MyAdapterItem adapter;
    private List<RecyclerItem> listaItens;
    private String titulo;
    private String descricao;
    private TextView verTudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar, Navigation Drawer, FloatingActionButton
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Instanciando Variáveis
        recyclerView = findViewById(R.id.recyclerTexto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        verTudo = findViewById(R.id.verTudo);

        listaItens = new ArrayList<>();
        titulo = "Lorem ipsum dolor sit amet consectetur";
        descricao = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae elit id quam ornare tristique.";

        //Gera dado para listas
        listaItens.add(new RecyclerItem(titulo, descricao, false, POST_PESQUISA));
        listaItens.add(new RecyclerItem(titulo, descricao, false, POST_TEXTO));
        listaItens.add(new RecyclerItem(titulo, descricao, false, POST_QUIZ));

        //Set Adapter Texto
        adapter = new MyAdapterItem(listaItens, this);
        recyclerView.setAdapter(adapter);

        //Seta abrir todas as publicações
        verTudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CategoriaActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuSearch) {

        } else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_conta) {

        } else if (id == R.id.nav_ranking) {
            Intent i = new Intent(MainActivity.this, RankingActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_categorias) {
            Intent i = new Intent(MainActivity.this, CategoriaActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_salvos) {

        } else if (id == R.id.nav_sugestao) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_help) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
