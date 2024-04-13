package DAO;

import infra.ConnectionFactory;
import model.Produto;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAO implements IProdutoDAO{
    private static Connection con;
    public ProdutoDAO(Connection connection){
        this.con = connection;
    }
    @Override
    public Produto save(Produto prod) {
        try{
            String sql = "insert into Produto(nome,valor,estoque,quantidadeVendida) values (?, ? ,? , ?)";
            PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, prod.getNome());
            pst.setDouble(2,prod.getValor());
            pst.setInt(3,prod.getEstoque());
            pst.setInt(4,prod.getQuantidadeVendida());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                prod.setProdutoId(rs.getInt(1)); // Define o ID gerado no objeto Usuario
            }
            //con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return prod;
    }

    @Override
    public Produto update(Produto prod) {
        try{
            String sql = "update Produto set nome = ? , valor = ? , estoque = ? , quantidadeVendida = ? where ProdutoId = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, prod.getNome());
            pst.setDouble(2,prod.getValor());
            System.out.println("estoque update"+prod.getEstoque());
            pst.setInt(3,prod.getEstoque());
            pst.setInt(4,prod.getQuantidadeVendida());
            pst.setInt(5, prod.getProdutoId());
            pst.executeUpdate();
            //con.close();

        }catch (Exception e){
            System.out.println(e);
        }
        return prod;
    }

    @Override
    public void delete(int id) {
        String sql = "delete from Produto where  ProdutoId = ?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
            //con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public List<Produto> findAll() {
        String sql = "select * from Produto ";
        List<Produto> produtos = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("ProdutoId");
                String nome = rs.getString("nome");
                double valor = rs.getDouble("valor");
                int estoque = rs.getInt("estoque");
                int quantidadeVendida = rs.getInt("quantidadeVendida");
                Produto prod = new Produto(id,nome,valor ,estoque,quantidadeVendida) ;
                produtos.add(prod);
            }
            //con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return produtos;
    }

    @Override
    public Optional<Produto> findById(int id) {
        String sql = "select * from Produto where ProdutoId = ?";
        Produto prod = null;
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int pkey = rs.getInt("ProdutoId");
                String nome = rs.getString("nome");
                double valor = rs.getDouble("valor");
                int estoque = rs.getInt("estoque");
                int quantidadeVendida = rs.getInt("quantidadeVendida");
                prod = new Produto(id,nome,valor ,estoque,quantidadeVendida);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return Optional.ofNullable(prod);
    }


}

