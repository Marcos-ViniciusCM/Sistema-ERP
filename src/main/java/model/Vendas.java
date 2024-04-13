package model;

import java.util.Date;

public class Vendas {

    private int idVenda;
    private int idProduto;
    String nomeComprador;
    private float valorPago;
    private String formaPagento;
    private Date dataVendido;
    private float trocoValor;
    private boolean statusVenda;
    private float valorProduto;
    private int quantidade;

    public Vendas(int idVenda, int idProduto, String nomeComprador, float valorPago, String formaPagento, Date dataVendido, boolean statusVenda) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.nomeComprador = nomeComprador;
        this.valorPago = valorPago;
        this.formaPagento = formaPagento;
        this.dataVendido = dataVendido;
        this.statusVenda = statusVenda;
    }

    public Vendas(int idProduto, String nomeComprador, float valorPago, String formaPagento, Date dataVendido, boolean statusVenda) {
        this.idProduto = idProduto;
        this.nomeComprador = nomeComprador;
        this.valorPago = valorPago;
        this.formaPagento = formaPagento;
        this.dataVendido = dataVendido;
        this.statusVenda = statusVenda;
    }

    public Vendas(int idProduto, String nomeComprador, float valorPago, String formaPagento, Date dataVendido, boolean statusVenda, float valorProduto) {
        this.idProduto = idProduto;
        this.nomeComprador = nomeComprador;
        this.valorPago = valorPago;
        this.formaPagento = formaPagento;
        this.dataVendido = dataVendido;
        this.statusVenda = statusVenda;
        this.valorProduto = valorProduto;
    }

    public Vendas(int idProduto, String nomeComprador, String formaPagento, int quantidade) {
        this.idProduto = idProduto;
        this.nomeComprador = nomeComprador;
        this.formaPagento = formaPagento;
        this.quantidade = quantidade;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public String getFormaPagento() {
        return formaPagento;
    }

    public void setFormaPagento(String formaPagento) {
        this.formaPagento = formaPagento;
    }

    public Date getDataVendido() {
        return dataVendido;
    }

    public void setDataVendido(Date dataVendido) {
        this.dataVendido = dataVendido;
    }

    public boolean isStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(boolean statusVenda) {
        this.statusVenda = statusVenda;
    }

    public float getTrocoValor() {
        return trocoValor;
    }

    public void setTrocoValor(float trocoValor) {
        this.trocoValor = trocoValor;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }
}