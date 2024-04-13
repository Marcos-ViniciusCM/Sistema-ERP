package acoes;

import DAO.ProdutoDAO;
import DAO.VendasDAO;
import infra.ConnectionFactory;
import jdk.vm.ci.meta.Local;
import model.Produto;
import model.Vendas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DashBoard implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectionFactory.getConnection();
        VendasDAO vendasDao = new VendasDAO(con);
        List<Vendas> todasVendas = vendasDao.findAll();
        List<Vendas> lastVendas = vendasDao.lastSell();
        List<Vendas> ultimasVenda = new ArrayList<>();
        List<Vendas> vendasDiaria = new ArrayList<>();
        int quantidadeVendasDiaria = 0;
        float valorArrecadadoDia = 0;
        int quantidadeVendasMensal = 0;
        float valorArrecadadoMensal = 0;
        LocalDate dataLocal = LocalDate.now();
        int mesAtual = dataLocal.getMonthValue();
        int anoAtual = dataLocal.getYear();


        //calcula o valor do troco de todas as vendas
        for(Vendas v : todasVendas){
            float valorPago = v.getValorPago();
            int idProduto = v.getIdProduto();
            float valorProduto = vendasDao.getValorProduto(idProduto);
            v.setValorProduto(valorProduto);
            float troco = valorPago - valorProduto;
            v.setTrocoValor(troco);
        }

        for(Vendas v : lastVendas){
            float valorPago = v.getValorPago();
            int idProduto = v.getIdProduto();
            float valorProduto = vendasDao.getValorProduto(idProduto);
            v.setValorProduto(valorProduto);
            float troco = valorPago - valorProduto;
            v.setTrocoValor(troco);
            ultimasVenda.add(v);
        }





        //calcular o valorDiario
        for(Vendas v : todasVendas){
            Date dataVenda = v.getDataVendido();
            java.util.Date utilDate = new java.util.Date(dataVenda.getTime());
            LocalDate dataVendidaLocal = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(dataVendidaLocal.equals(dataLocal)){
                quantidadeVendasDiaria++;
                vendasDiaria.add(v);
                valorArrecadadoDia +=v.getValorProduto();
            }
        }


        //calcula o valorMensal
        for(Vendas v : todasVendas){
            Date dataVenda = v.getDataVendido();
            java.util.Date utilDate = new java.util.Date(dataVenda.getTime());
            LocalDate dataVendidaLocal = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(dataVendidaLocal.getMonth().getValue() == mesAtual && dataVendidaLocal.getYear() == anoAtual) {
                    quantidadeVendasMensal++;
                    valorArrecadadoMensal += v.getValorProduto();
                }
            }

                // Define os atributos do request
        request.setAttribute("ultimasVendas",ultimasVenda);

        request.setAttribute("vendasDoDia",vendasDiaria);
        request.setAttribute("valorArrecadadoDia",valorArrecadadoDia);
        request.setAttribute("quantidadeVendasMensal",quantidadeVendasMensal);
        request.setAttribute("valorArrecadadoMensal",valorArrecadadoMensal);
        request.setAttribute("quantidadeVendasDia",quantidadeVendasDiaria);

        //Define produto
        ProdutoDAO ProdutoDao = new ProdutoDAO(con);
        List<Produto> produtos = ProdutoDao.findAll();

        request.setAttribute("Listaprodutos",produtos);



        return "/DashBoard.jsp";
    }
}
