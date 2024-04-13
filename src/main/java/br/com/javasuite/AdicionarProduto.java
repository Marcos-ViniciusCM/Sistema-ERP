package br.com.javasuite;

import DAO.ProdutoDAO;
import acoes.Acao;
import infra.ConnectionFactory;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addProduto")
public class AdicionarProduto extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectionFactory.getConnection();
        ProdutoDAO produtoDao = new ProdutoDAO(con);
        String nomeProduto = request.getParameter("nome");
        System.out.println("nome " + nomeProduto);

        // Verificar se o preço é nulo antes de usá-lo
        String precoProduto = request.getParameter("preço");
        System.out.println("preco " + precoProduto);

        // Verificar se o estoque é nulo antes de usá-lo
        String estoqueProduto = request.getParameter("estoque");
        System.out.println("estoque " + estoqueProduto);


        double valor = Double.parseDouble(precoProduto);
        int estoque = Integer.parseInt(estoqueProduto);
        Produto produto = new Produto(nomeProduto,valor,estoque);
        produtoDao.save(produto);
        response.sendRedirect("controller?acao=ListaProduto");
    }
}
