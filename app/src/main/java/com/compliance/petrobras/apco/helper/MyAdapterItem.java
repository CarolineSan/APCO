package com.compliance.petrobras.apco.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.compliance.petrobras.apco.R;
import com.compliance.petrobras.apco.model.RecyclerItem;

import java.util.List;

import static com.compliance.petrobras.apco.helper.Constant.POST_PESQUISA;
import static com.compliance.petrobras.apco.helper.Constant.POST_QUIZ;
import static com.compliance.petrobras.apco.helper.Constant.POST_TEXTO;

public class MyAdapterItem extends RecyclerView.Adapter<MyAdapterItem.ViewHolder> {

    private List<RecyclerItem> listaItens;
    private Context mContext;

    public MyAdapterItem(List<RecyclerItem> listaItens, Context mContext) {
        this.listaItens = listaItens;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyAdapterItem.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        switch (i) {
            case POST_TEXTO:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_item_texto, viewGroup, false);
                return new MyAdapterItem.ViewHolder(v);
            case POST_PESQUISA:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_item_pesquisa, viewGroup, false);
                return new MyAdapterItem.ViewHolder(v);
            case POST_QUIZ:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_item_quiz, viewGroup, false);
                return new MyAdapterItem.ViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapterItem.ViewHolder viewHolder, int i) {

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
                    viewHolder.curtir.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_thumb_up_black_24dp);
                    item.setCurtido(false);
                } else {
                    viewHolder.curtir.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_thumb_up_blue_24dp);
                    item.setCurtido(true);
                }
            }
        });

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

        public TextView txtTitle;
        public TextView txtDescricao;
        public TextView txtOptionDigit;
        public Button curtir;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescricao = itemView.findViewById(R.id.txtDescricao);
            txtOptionDigit = itemView.findViewById(R.id.txtOptionDigit);
            curtir = itemView.findViewById(R.id.curtirTeste);
        }

    }
}
