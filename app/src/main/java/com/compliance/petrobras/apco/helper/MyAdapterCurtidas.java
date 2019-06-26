package com.compliance.petrobras.apco.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compliance.petrobras.apco.R;
import com.compliance.petrobras.apco.model.RecyclerItem;

import java.util.List;

import static com.compliance.petrobras.apco.model.Constant.CURTIDAS_PESQUISA;
import static com.compliance.petrobras.apco.model.Constant.CURTIDAS_TEXTO;
import static com.compliance.petrobras.apco.model.Constant.CURTIDAS_QUIZ;

public class MyAdapterCurtidas extends RecyclerView.Adapter<MyAdapterCurtidas.ViewHolder> {

    private List<RecyclerItem> listaItens;
    private Context mContext;

    public MyAdapterCurtidas(List<RecyclerItem> listaItens, Context mContext) {
        this.listaItens = listaItens;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyAdapterCurtidas.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        switch (i) {
            case CURTIDAS_TEXTO:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.curtidas_item_texto, viewGroup, false);
                return new MyAdapterCurtidas.ViewHolder(v);
            case CURTIDAS_PESQUISA:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.curtidas_item_pesquisa, viewGroup, false);
                return new MyAdapterCurtidas.ViewHolder(v);
            case CURTIDAS_QUIZ:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.curtidas_item_quiz, viewGroup, false);
                return new MyAdapterCurtidas.ViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapterCurtidas.ViewHolder viewHolder, int i) {

        final RecyclerItem item = listaItens.get(i);
        viewHolder.curtidas.setText(String.valueOf(item.getCurtidas()));
    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    @Override
    public int getItemViewType(int position) {
        /**
         * Recebe com argumento a posição da publicação
         * e retorna o tipo de visão desta publicação que é do tipo int
         */
        return listaItens.get(position)
                .getTypeView();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView curtidas;

        public ViewHolder(View itemView) {
            super(itemView);
            curtidas = itemView.findViewById(R.id.number_curtidas);
        }

    }
}
