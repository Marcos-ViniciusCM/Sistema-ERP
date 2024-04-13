package acoes;

import DAO.VendasDAO;
import infra.ConnectionFactory;
import model.Vendas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class AtualizarEstado implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectionFactory.getConnection();
        VendasDAO vendasDao = new VendasDAO(con);
        String idParam = request.getParameter("id");
        System.out.println("parametro id"+idParam);
        List<Vendas> todasVendas = vendasDao.findAll();
        int id = Integer.valueOf(idParam);
        boolean estado = false;

        for(Vendas v : todasVendas){
            if (id == v.getIdVenda()){
                if(v.isStatusVenda() == true){
                    estado = false;
                    v.setStatusVenda(false);
                }else{
                    estado = true;
                    v.setStatusVenda(true);

                }
            }
        }

        vendasDao.updateStatus(estado,id);
        return "/WEB-INF/controller?acao=ListaPedido";
    }
}
