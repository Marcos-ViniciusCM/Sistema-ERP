package br.com.javasuite;

import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import DAO.VendasDAO;
import infra.ConnectionFactory;
import model.Produto;
import model.Vendas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet("/fazerCompra")
public class FazerCompras  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectionFactory.getConnection();
        VendasDAO vendasDao = new VendasDAO(con);
        ProdutoDAO produtoDao = new ProdutoDAO(con);
        List<Produto> produtos = produtoDao.findAll();
        String[] idProdutos = request.getParameterValues("idProduto");
        String[] quantidades = request.getParameterValues("quantidade");
        String[] valoresPagos = request.getParameterValues("valorPago");
        String[] formasPagamento = request.getParameterValues("metodo-pagamento");
        String nomeComprador = request.getParameter("nameComprador");
        float valorProduto = 0;


        Date dataAtualUtil = new Date();
        java.sql.Date dataAtual = new java.sql.Date(dataAtualUtil.getTime());
        float valorMinimo = 0;


            for (int i = 0; i < produtos.size(); i++) {
                int produtoId = Integer.parseInt(idProdutos[i]);
                int quantidade = Integer.parseInt(quantidades[i]);
                float valorPago = Float.parseFloat(valoresPagos[i]);
                String formaPagento = formasPagamento[i];
                if (produtos.get(i).getProdutoId() == produtoId) {
                    int estoqueAtual = produtos.get(i).getEstoque();
                    int novoEstoque = estoqueAtual - quantidade;
                    valorProduto = (float) produtos.get(i).getValor();
                    produtos.get(i).setEstoque(novoEstoque);
                    produtoDao.update(produtos.get(i));
                    valorMinimo = (float) produtos.get(i).getValor() * quantidade;
                    if(quantidade > 0) {
                        Vendas venda = new Vendas(produtoId, nomeComprador, valorPago, formaPagento, dataAtual, false, valorProduto);
                        vendasDao.save(venda);
                    }
                }
            }

        request.setAttribute("valorMinimo", valorMinimo);
        response.sendRedirect("controller?acao=ListaCompras");
    }
}
