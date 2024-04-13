package acoes;

import DAO.UsuarioDAO;
import infra.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RemoveUsuario implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String idParam = request.getParameter("id");

        Connection con = ConnectionFactory.getConnection();
        UsuarioDAO userDao = new UsuarioDAO(con);

        userDao.delete(Integer.parseInt(idParam));
        return "/controller?acao=ListaUsuarios";

    }
}
