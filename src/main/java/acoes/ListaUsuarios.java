package acoes;

import DAO.UsuarioDAO;
import infra.ConnectionFactory;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ListaUsuarios implements Acao{
@Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectionFactory.getConnection();
        UsuarioDAO dao = new UsuarioDAO(con);
        List<Usuario> user = dao.findAll();
        request.setAttribute("usuarios", user);
        return "Usuarios.jsp";


    }
}
