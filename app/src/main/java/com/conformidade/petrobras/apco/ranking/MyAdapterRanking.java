package com.conformidade.petrobras.apco.ranking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.conformidade.petrobras.apco.R;

import java.util.List;

public class MyAdapterRanking extends RecyclerView.Adapter<MyAdapterRanking.ViewHolder> {

    private List<RecyclerRanking> listaItens;

    public MyAdapterRanking(List<RecyclerRanking> listaItens) {
        this.listaItens = listaItens;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ranking_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        final RecyclerRanking item = listaItens.get(i);
        viewHolder.txtNome.setText(item.getNome());
        viewHolder.txtRanking.setText(item.getRanking());
        viewHolder.txtPontos.setText(item.getPontos());

    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNome;
        public TextView txtRanking;
        public TextView txtPontos;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.nome_ranking);
            txtRanking = itemView.findViewById(R.id.ranking_number);
            txtPontos = itemView.findViewById(R.id.pontos);
        }

    }
}
