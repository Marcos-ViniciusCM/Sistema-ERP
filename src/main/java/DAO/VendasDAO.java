package DAO;

import model.Vendas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendasDAO implements IVendasDAO{

    private static Connection con;

    public VendasDAO(Connection connection){
        this.con = connection;
    }

    @Override
    public Vendas save(Vendas venda) {
        try {
            String sql = "insert into Venda(valorPago,nomeComprador,dataVendido,produto_id,formaPagamento) values ( ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setFloat(1,venda.getValorPago());
            pst.setString(2,venda.getNomeComprador());
            pst.setDate(3, (Date) venda.getDataVendido());
            pst.setInt(4,venda.getIdProduto());
            pst.setString(5,venda.getFormaPagento());
            pst.executeUpdate();
            // Recuperar a chave gerada (se necessário)
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                venda.setIdVenda(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return venda;
    }

    @Override
    public void updateStatus(boolean estado,int id) {
        try {
            System.out.println("estadoooooooooo"+estado);
            String sql = "UPDATE Venda SET  estadoVenda = ? WHERE idVenda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setBoolean(1,estado);
            pst.setInt(2,id);
            pst.executeUpdate();
            //con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM Venda WHERE idVenda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Vendas> findAll() {
        List<Vendas> vendas = new ArrayList<>();;
        try {
            String sql = "SELECT * FROM Venda";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                int idProduto = rs.getInt("produto_id");
                String nomeComprador = rs.getString("nomeComprador");
                float valorPago = rs.getFloat("valorPago");
                Date dataVendido = rs.getDate("DataVendido");
                String formaPagamento = rs.getString("formaPagamento");
                boolean estado = rs.getBoolean("estadoVenda");
                Vendas venda = new Vendas(idVenda,idProduto,nomeComprador,valorPago,formaPagamento ,dataVendido,estado);
                vendas.add(venda);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vendas;
    }
@Override
    public List<Vendas> lastSell() {
        List<Vendas> vendas = new ArrayList<>();;
        try {
            String sql = "SELECT * FROM Venda order by DataVendido desc limit 6";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                int idProduto = rs.getInt("produto_id");
                String nomeComprador = rs.getString("nomeComprador");
                float valorPago = rs.getFloat("valorPago");
                Date dataVendido = rs.getDate("DataVendido");
                String formaPagamento = rs.getString("formaPagamento");
                boolean estado = rs.getBoolean("estadoVenda");
                Vendas venda = new Vendas(idVenda,idProduto,nomeComprador,valorPago,formaPagamento ,dataVendido,estado);
                vendas.add(venda);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vendas;
    }

    @Override
    public Optional<Vendas> findById(int id) {
        String sql = "SELECT * FROM Venda WHERE idVenda = ?";
        Vendas venda = null;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                int idProduto = rs.getInt("produto_id");
                String nomeComprador = rs.getString("nomeComprador");
                float valorPago = rs.getFloat("valorPago");
                Date dataVendido = rs.getDate("DataVendido");
                String formaPagamento = rs.getString("formaPagamento");
                boolean estado = rs.getBoolean(" estadoVenda");
                venda = new Vendas(idVenda,idProduto,nomeComprador,valorPago,formaPagamento ,dataVendido,estado);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(venda);
    }
    public float getValorProduto(int id) {
        float valorProduto = 0;
        String sql = "SELECT valor FROM Produto WHERE ProdutoId = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                valorProduto = rs.getFloat("valor");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valorProduto;
    }

}
