package acoes;

import DAO.ProdutoDAO;
import infra.ConnectionFactory;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ListaProduto implements Acao{
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectionFactory.getConnection();
        ProdutoDAO dao = new ProdutoDAO(con);
        List<Produto> produtos = dao.findAll();

        request.setAttribute("produtos",produtos);

        return "/Produto.jsp";
    }
}
