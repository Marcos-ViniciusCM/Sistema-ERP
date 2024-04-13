package acoes;

import DAO.VendasDAO;
import infra.ConnectionFactory;
import model.Vendas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ListaPedido implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectionFactory.getConnection();
        VendasDAO vendasDao = new VendasDAO(con);
        List<Vendas> todasVendas = vendasDao.findAll();

        String estadoText = request.getParameter("estado");

        for(Vendas v : todasVendas){
            float valorPago = v.getValorPago();
            int idProduto = v.getIdProduto();
            float valorProduto = vendasDao.getValorProduto(idProduto);
            v.setValorProduto(valorProduto);
            float troco = valorPago - valorProduto;
            v.setTrocoValor(troco);

        }
        request.setAttribute("listaVendas",todasVendas);
        return "/WEB-INF/Pedido.jsp";
    }
}
