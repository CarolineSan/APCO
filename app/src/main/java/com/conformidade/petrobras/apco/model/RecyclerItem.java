package com.conformidade.petrobras.apco.model;

public class RecyclerItem {

    private String titulo;
    private String descricao;
    private boolean curtido;

    public RecyclerItem(String titulo, String descricao, boolean curtido) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.curtido = curtido;
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
}
