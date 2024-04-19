package DAO;

import infra.ConnectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO implements IUserDAO{
    private final Connection con;

    public UsuarioDAO(Connection con){
        this.con = con;
    }
    @Override
    public Usuario save(Usuario user) {
        try{
            String sql = "insert into Usuario(nome,email,cargo) values (?, ? ,?)";
            PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, user.getNome());
            pst.setString(2,user.getEmail());
            pst.setString(3, user.getCargo());

            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            user.setId(rs.getInt(1)); // Define o ID gerado no objeto Usuario
        }
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return user;
    }

    @Override
    public Usuario update(Usuario user) {
        try{
            String sql = "update Usuario set nome = ? , email = ? , cargo = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getCargo());
            pst.setInt(4,user.getId());
            pst.executeUpdate();
            con.close();

        }catch (Exception e){
            System.out.println(e);
        }
        return user;
    }

    @Override
    public void delete(int id) {
    String sql = "delete from Usuario where IdUsuario = ?";
    try{
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        con.close();
    }catch (Exception e){
        System.out.println(e);
    }
    }

    @Override
    public List<Usuario> findAll() {
        String sql = "select * from Usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try{
           PreparedStatement pst = con.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           while (rs.next()){
               int id = rs.getInt("IdUsuario");
               String nome = rs.getString("nome");
               String email = rs.getString("email");
               String cargo = rs.getString("cargo");
               Usuario user = new Usuario(id,nome,email ,cargo) ;
               usuarios.add(user);
           }
           rs.close();
           con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return usuarios;
    }

    @Override
    public Optional<Usuario> findById(int id) {
        String sql = "select * from Usuario where IdUsuario = ?";
        Usuario user = null;
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int pkey = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cargo = rs.getString("cargo");
                user = new Usuario(pkey,nome,email ,cargo) ;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return Optional.ofNullable(user);
    }



    }


