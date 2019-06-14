package com.compliance.petrobras.apco.model;

public class RecyclerItem {

    private String titulo;
    private String descricao;
    private boolean curtido;
    private int typeView; //Onde será definido o tipo de visão de cada publicação

    public RecyclerItem(String titulo, String descricao, boolean curtido, int typeView) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.curtido = curtido;
        this.typeView = typeView;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCurtido() {
        return curtido;
    }

    public void setCurtido(boolean curtido) {
        this.curtido = curtido;
    }

    public int getTypeView() {
        return typeView;
    }

    public void setTypeView(int typeView) {
        this.typeView = typeView;
    }
}
