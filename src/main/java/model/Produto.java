package model;

public class Produto {
    private int produtoId;
    private String nome;
    private double valor;
    private int estoque;
    private int quantidadeVendida;


    public Produto(int produtoId, String nome, double valor, int estoque, int quantidadeVendida) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.valor = valor;
        this.estoque = estoque;
        this.quantidadeVendida = quantidadeVendida;
    }

    public Produto(String nome, double valor, int estoque, int quantidadeVendida) {
        this.nome = nome;
        this.valor = valor;
        this.estoque = estoque;
        this.quantidadeVendida = quantidadeVendida;
    }

    public Produto(String nome, double valor, int estoque) {
        this.nome = nome;
        this.valor = valor;
        this.estoque = estoque;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
}
