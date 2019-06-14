package com.compliance.petrobras.apco;

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

    private RecyclerView recyclerViewTexto;
    private RecyclerView recyclerViewPesquisa;
    private RecyclerView recyclerViewQuiz;
    private MyAdapterItem adapter;
    private List<RecyclerItem> listaItensTexto;
    private List<RecyclerItem> listaItensPesquisa;
    private List<RecyclerItem> listaItensQuiz;
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

        listaItensTexto = new ArrayList<>();
        listaItensPesquisa = new ArrayList<>();
        listaItensQuiz = new ArrayList<>();
        titulo = "Lorem ipsum dolor sit amet consectetur";
        descricao = "Nullam venenatis erat sed bibendum aliquam. Ut turpis turpis, viverra eu eros eget, pellentesque dictum risus. Etiam consectetur, lorem sit amet laoreet aliquet, velit tellus fermentum nunc, ut facilisis massa nulla a magna. Nullam cursus id lectus eget rhoncus. Nam cursus, ante ut varius mollis, sapien diam maximus mauris, finibus congue nunc lectus nec purus. Donec luctus dictum fringilla.";

        //Gera dado para listas
        for(int i = 0; i<2; i++) {
            listaItensTexto.add(new RecyclerItem(titulo, descricao, false, POST_TEXTO));
            listaItensPesquisa.add(new RecyclerItem(titulo, descricao, false, POST_PESQUISA));
            listaItensQuiz.add(new RecyclerItem(titulo, descricao, false, POST_QUIZ));
        }
        //Set Adapter Texto
        adapter = new MyAdapterItem(listaItensTexto, this);
        recyclerViewTexto.setAdapter(adapter);

        //Set Adapter Pesquisa
        adapter = new MyAdapterItem(listaItensPesquisa, this);
        recyclerViewPesquisa.setAdapter(adapter);

        //Set Adapter Quiz
        adapter = new MyAdapterItem(listaItensQuiz, this);
        recyclerViewQuiz.setAdapter(adapter);
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
