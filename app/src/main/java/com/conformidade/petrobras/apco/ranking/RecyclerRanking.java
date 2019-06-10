package com.conformidade.petrobras.apco.ranking;

public class RecyclerRanking {

    private String nome;
    private String ranking;
    private String pontos;

    public RecyclerRanking(String nome, String ranking, String pontos) {
        this.nome = nome;
        this.ranking = ranking;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
    }
}
