package com.compliance.petrobras.apco.categoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.compliance.petrobras.apco.R;
import com.compliance.petrobras.apco.helper.CustomTabLayout;
import com.compliance.petrobras.apco.helper.MyAdapterItem;
import com.compliance.petrobras.apco.model.RecyclerItem;

import java.util.ArrayList;
import java.util.List;

import static com.compliance.petrobras.apco.helper.Constant.POST_PESQUISA;
import static com.compliance.petrobras.apco.helper.Constant.POST_QUIZ;
import static com.compliance.petrobras.apco.helper.Constant.POST_TEXTO;

public class CategoriaActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private CustomTabLayout tabLayout;
    private RecyclerView recyclerView;
    private MyAdapterItem adapter;
    private List<RecyclerItem> listaItens;
    private String titulo;
    private String descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        //Configura Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categorias");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);

        //Configurando toda a exibição de itens
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaItens = new ArrayList<>();
        titulo = "Lorem ipsum dolor sit amet consectetur";
        descricao = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae elit id quam ornare tristique.";

        //Gera dado para listas
        for(int i = 0; i<2; i++) {
            listaItens.add(new RecyclerItem(titulo, descricao, false, POST_TEXTO));
            listaItens.add(new RecyclerItem(titulo, descricao, false, POST_TEXTO));
            listaItens.add(new RecyclerItem(titulo, descricao, false, POST_PESQUISA));
            listaItens.add(new RecyclerItem(titulo, descricao, false, POST_QUIZ));
        }

        adapter = new MyAdapterItem(listaItens, this);
        recyclerView.setAdapter(adapter);

        //Configura Menu / TabLayout
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home_white_24dp));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 4"));

        tabLayout.setOnTabSelectedListener(new CustomTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(CustomTabLayout.Tab tab) {
                recarregaPublicacoes(tab);
                mostrarSubCategorias(tab);
                //tabLayout.getTabAt(1).select();
            }

            @Override
            public void onTabUnselected(CustomTabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(CustomTabLayout.Tab tab) {
                int p = tab.getPosition();
                if (p == 0) {
                    mostrarMenuRaiz(tab);
                }
            }
        });
    }

    private void mostrarSubCategorias(CustomTabLayout.Tab tab) {
        tab.setIcon(R.drawable.ic_keyboard_return_white_24dp).setText("");
        int totalTabs = tabLayout.getTabCount();
        int i = tab.getPosition();
        for (int j = totalTabs - 1; j >= 0; j--) {
            if (j != i) {
                tabLayout.removeTabAt(j);
            }
        }
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home_white_24dp));
        tabLayout.addTab(tabLayout.newTab().setText("Submenu 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Submenu 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Submenu 3"));
    }

    private void mostrarMenuRaiz(CustomTabLayout.Tab tab) {
        tab.setIcon(R.drawable.ic_home_white_24dp);
        int totalTabs = tabLayout.getTabCount();
        int i = tab.getPosition();
        for (int j = totalTabs - 1; j >= 0; j--) {
            if (j != i) {
                tabLayout.removeTabAt(j);
            }
        }
        tabLayout.addTab(tabLayout.newTab().setText("Menu 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 4"));
        //tabLayout.getTabAt(0).select();
    }

    private void recarregaPublicacoes(CustomTabLayout.Tab tab) {
        listaItens.clear();
        int i = tab.getPosition();
        if (i == 1) {
            for(int j = 0; j < 2; j++) {
                listaItens.add(new RecyclerItem(titulo, descricao, false, POST_TEXTO));
                listaItens.add(new RecyclerItem(titulo, descricao, false, POST_TEXTO));
                listaItens.add(new RecyclerItem(titulo, descricao, false, POST_PESQUISA));
                listaItens.add(new RecyclerItem(titulo, descricao, false, POST_QUIZ));
            }
        } else {
            listaItens.add(new RecyclerItem(titulo, descricao, false, POST_TEXTO));
            listaItens.add(new RecyclerItem(titulo, descricao, false, POST_QUIZ));
            listaItens.add(new RecyclerItem(titulo, descricao, false, POST_PESQUISA));
        }
        adapter = new MyAdapterItem(listaItens, CategoriaActivity.this);
        recyclerView.setAdapter(adapter);
    }

}
