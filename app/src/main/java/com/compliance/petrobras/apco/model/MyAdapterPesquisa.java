package com.compliance.petrobras.apco.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.compliance.petrobras.apco.R;

import java.util.List;

public class MyAdapterPesquisa extends RecyclerView.Adapter<MyAdapterPesquisa.ViewHolder> {

    private List<RecyclerItem> listaItens;
    private Context mContext;

    public MyAdapterPesquisa(List<RecyclerItem> listaItens, Context mContext) {
        this.listaItens = listaItens;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_item_pesquisa, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        final RecyclerItem item = listaItens.get(i);
        viewHolder.txtTitle.setText(item.getTitulo());
        viewHolder.txtDescricao.setText(item.getDescricao());
        viewHolder.txtOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(mContext, viewHolder.txtOptionDigit);
                popupMenu.inflate(R.menu.option_menu_item);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu_item_salvar:
                                Toast.makeText(mContext, "Salvo!", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_item_compartilhar:
                                Toast.makeText(mContext, "Compartilhado!", Toast.LENGTH_SHORT).show();
                                break;
                                default:
                                    break;
                        }
                        return false;
                    }
                });
                popupMenu.show();

            }
        });
        viewHolder.curtir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.isCurtido()) {
                    viewHolder.curtir.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_curtir_border_black_24dp, 0, 0, 0);
                    item.setCurtido(false);
                } else {
                    viewHolder.curtir.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_curtido, 0, 0, 0);
                    item.setCurtido(true);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public TextView txtDescricao;
        public TextView txtOptionDigit;
        public TextView curtir;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescricao = itemView.findViewById(R.id.txtDescricao);
            txtOptionDigit = itemView.findViewById(R.id.txtOptionDigit);
            curtir = itemView.findViewById(R.id.curtir);
        }

    }
}
