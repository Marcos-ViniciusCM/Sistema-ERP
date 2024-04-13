package DAO;

import model.Usuario;
import model.Vendas;

import java.util.List;
import java.util.Optional;

public interface IVendasDAO {
    public Vendas save(Vendas venda);
    public void updateStatus(boolean estado,int id);
    public void delete(int id);
    public List<Vendas> findAll();
    public List<Vendas> lastSell();
    public Optional<Vendas> findById(int id);
}
