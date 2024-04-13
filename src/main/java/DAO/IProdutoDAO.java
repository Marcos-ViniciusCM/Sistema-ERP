package DAO;

import model.Produto;
import model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IProdutoDAO {
    public Produto save(Produto prod);
    public Produto update(Produto prod);
    public void delete(int id);
    public List<Produto> findAll();
    public Optional<Produto> findById(int id);
}
