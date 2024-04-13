package br.com.javasuite;

import DAO.UsuarioDAO;
import infra.ConnectionFactory;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addUser")
public class AdicionarUsuarios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");

        System.out.println(nome);
        System.out.println(email);
        System.out.println(cargo);



        Usuario user = new Usuario(nome,email,cargo);
        Connection con = ConnectionFactory.getConnection();
         UsuarioDAO dao = new UsuarioDAO(con);
       dao.save(user);

   response.sendRedirect("controller?acao=ListaUsuarios");

    }
}
