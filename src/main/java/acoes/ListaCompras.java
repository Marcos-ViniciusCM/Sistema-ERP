package acoes;

import DAO.ProdutoDAO;
import DAO.VendasDAO;
import infra.ConnectionFactory;
import model.Produto;
import model.Vendas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class ListaCompras implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectionFactory.getConnection();
        ProdutoDAO dao = new ProdutoDAO(con);
        List<Produto> produtos = dao.findAll();
        request.setAttribute("ListaProdutos", produtos);

        // Verifica se os parâmetros não são nulos antes de convertê-los
        String idProdutoParam = request.getParameter("idProduto");
        String quantidadeParam = request.getParameter("quantidade");
        if (idProdutoParam != null && quantidadeParam != null) {
            int idProduto = Integer.parseInt(idProdutoParam);
            int quantidade = Integer.parseInt(quantidadeParam);

            float valorMinimo = 0;
            for (Produto p : produtos) {
                if (p.getProdutoId() == idProduto) {
                    int estoqueAtual = p.getEstoque();
                    int novoEstoque = estoqueAtual - quantidade;
                    p.setEstoque(novoEstoque);
                    dao.update(p);
                    valorMinimo = (float) p.getValor() * quantidade;
                }
            }
            request.setAttribute("valorMinimo", valorMinimo);
        }

        return "/Compra.jsp";
    }
}