package com.conformidade.petrobras.apco;

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

import com.conformidade.petrobras.apco.categoria.CategoriaActivity;
import com.conformidade.petrobras.apco.model.MyAdapterPesquisa;
import com.conformidade.petrobras.apco.model.MyAdapterQuiz;
import com.conformidade.petrobras.apco.model.MyAdapterTexto;
import com.conformidade.petrobras.apco.model.RecyclerItem;
import com.conformidade.petrobras.apco.ranking.RankingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerViewTexto;
    private RecyclerView recyclerViewPesquisa;
    private RecyclerView recyclerViewQuiz;
    private MyAdapterTexto adapterTexto;
    private MyAdapterPesquisa adapterPesquisa;
    private MyAdapterQuiz adapterQuiz;
    private List<RecyclerItem> listaItens;
    private String titulo;
    private String descricao;

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
        recyclerViewTexto = findViewById(R.id.recyclerTexto);
        recyclerViewTexto.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPesquisa = findViewById(R.id.recyclerPesquisa);
        recyclerViewPesquisa.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewQuiz = findViewById(R.id.recyclerQuiz);
        recyclerViewQuiz.setLayoutManager(new LinearLayoutManager(this));

        listaItens = new ArrayList<>();
        titulo = "Lorem ipsum dolor sit amet consectetur";
        descricao = "Nullam venenatis erat sed bibendum aliquam. Ut turpis turpis, viverra eu eros eget, pellentesque dictum risus. Etiam consectetur, lorem sit amet laoreet aliquet, velit tellus fermentum nunc, ut facilisis massa nulla a magna. Nullam cursus id lectus eget rhoncus. Nam cursus, ante ut varius mollis, sapien diam maximus mauris, finibus congue nunc lectus nec purus. Donec luctus dictum fringilla.";

        //Gera dado para listas
        for(int i = 0; i<2; i++) {
            listaItens.add(new RecyclerItem(titulo, descricao));
        }
        //Set Adapter Texto
        adapterTexto = new MyAdapterTexto(listaItens, this);
        recyclerViewTexto.setAdapter(adapterTexto);

        //Set Adapter Pesquisa
        adapterPesquisa = new MyAdapterPesquisa(listaItens, this);
        recyclerViewPesquisa.setAdapter(adapterPesquisa);

        //Set Adapter Quiz
        adapterQuiz = new MyAdapterQuiz(listaItens, this);
        recyclerViewQuiz.setAdapter(adapterQuiz);
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
