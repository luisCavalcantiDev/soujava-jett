package br.com.emmanuelneri.vo;

import java.math.BigDecimal;

public class ProdutoVO {

    private final String nome;
    private final int quantidade;
    private final BigDecimal valor;

    public ProdutoVO(String nome, int quantidade, BigDecimal valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
