package DAO;

import model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    public Usuario save(Usuario user);
    public Usuario update(Usuario user);
    public void delete(int id);
    public List<Usuario>findAll();
    public Optional<Usuario>findById(int id);
}
