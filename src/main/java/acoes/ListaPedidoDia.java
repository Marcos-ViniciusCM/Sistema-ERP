package acoes;

import DAO.VendasDAO;
import infra.ConnectionFactory;
import model.Vendas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaPedidoDia implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectionFactory.getConnection();
        VendasDAO vendasDao = new VendasDAO(con);
        List<Vendas> todasVendas = vendasDao.findAll();
        List<Vendas> vendasDiaria = new ArrayList<>();
        LocalDate dataLocal = LocalDate.now();

        for(Vendas v : todasVendas){
            float valorPago = v.getValorPago();
            int idProduto = v.getIdProduto();
            float valorProduto = vendasDao.getValorProduto(idProduto);
            v.setValorProduto(valorProduto);
            float troco = valorPago - valorProduto;
            v.setTrocoValor(troco);

        }
        String estadoText = request.getParameter("estado");
        for(Vendas v : todasVendas){
            Date dataVenda = v.getDataVendido();
            java.util.Date utilDate = new java.util.Date(dataVenda.getTime());
            LocalDate dataVendidaLocal = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(dataVendidaLocal.equals(dataLocal)){
                vendasDiaria.add(v);
            }

        }
        System.out.println();
        request.setAttribute("listaVendas",vendasDiaria);

        return "/WEB-INF/Pedido.jsp";
    }
}

