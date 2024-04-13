package br.com.javasuite;

import acoes.Acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/controller")
public class ControlerService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String acaoNome = request.getParameter("acao");
            String pacote = "acoes.";
            Class classe = Class.forName(pacote+acaoNome);
            Acao acao = (Acao) classe.newInstance();


           String resultado = acao.executa(request,response);

           RequestDispatcher dispatcher = request.getRequestDispatcher(resultado);
           dispatcher.forward(request,response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
}
