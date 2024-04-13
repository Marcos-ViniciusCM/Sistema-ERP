<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>carta</title>
    <link rel="stylesheet" href="styles/dashboard.css">
    <link rel="stylesheet" href="fontawesome/css/all.min.css">
</head>
<body>
    <header>
        <div class="nav-bar">
            <h2>ERP SOFTWARE</h2>
            <ul>

                <li><a href="controller?acao=DashBoard"> <i class="fa-solid fa-house"></i>Dashboard</a></li>
                <li><a href="controller?acao=ListaUsuarios"><i class="fa-solid fa-user"></i>Usuario</a></li>
                <li><a href="controller?acao=ListaProduto"><i class="fa-solid fa-plus"></i>Produtos</a></li>
                <li><a href="controller?acao=ListaPedido"><i class="fa-solid fa-cart-shopping"></i>Pedidos</a></li>                <li><a href="controller?acao=ListaPedido"><i class="fa-solid fa-cart-shopping"></i>Pedidos</a></li>
                <li><a href="controller?acao=ListaCompras"><i class="fa-solid fa-credit-card"></i>Fazer Compra</a></li>

            </ul>
        </div>
        </header>
        <div class="vendas-totais">
            <div class="vendas">
                <i class="fa-solid fa-cart-shopping"></i>
                <h1>Vendas Diaria</h1>
                <h2>${quantidadeVendasDia} Realizada</h2>
                <p>Valor Arrecadado Diario:${valorArrecadadoDia}</p>
                <a href="controller?acao=ListaPedidoDia" class="saiba-mais">Mais Informações<i class="fa-solid fa-arrow-right"></i></a>
            </div>

            <div class="vendas-semanais">
                <i class="fa-solid fa-cart-shopping"></i>
                <h1>Vendas Mensais</h1>
                <h2>${quantidadeVendasMensal} Realizadas</h2>
                <p>Valor Arrecadado Mensal:${valorArrecadadoMensal}</p>
                <a href="controller?acao=ListaPedido" class="saiba-mais">Mais Informações <i class="fa-solid fa-arrow-right"></i></a>
            </div>

            <div class="pedidos-diarios">
                <i class="fa-solid fa-cart-shopping"></i>
                <h1>Pedidos Diario</h1>
                <div class="tabela-pedidos">
                    <table>
                        <thead>
                            <tr>
                                <th>Id Pedido</th>
                                <th>Valor</th>
                                <th>Cliente</th>
                            </tr>
                            <tbody>

                    <c:forEach var="quantidadeVendasDiarias" items="${vendasDoDia}">
                        <tr>
                            <td>${quantidadeVendasDiarias.idVenda}</td>
                            <td>${quantidadeVendasDiarias.valorPago}</td>
                            <td>${quantidadeVendasDiarias.nomeComprador}</td>
                        </tr>
                    </c:forEach>


                            </tbody>
                        </thead>
                    </table>
                    <p>Total Pedidos:${quantidadeVendasDiaria}</p>


                </div>
                  <a href="controller?acao=ListaPedidoDia" class="saiba-mais">Mais Informações<i class="fa-solid fa-arrow-right"></i></a>
            </div>

<div class="produtos-disponivel">
    <i class="fa-solid fa-cart-shopping"></i>
    <h1>Produtos Disponivel</h1>
    <div class="tabela-pedidos">
        <table>
            <thead>
                <tr>
                    <th>Produto</th>
                    <th>Quantidade</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="produtos" items="${Listaprodutos}">
                <tr>
                    <td>${produtos.nome}</td>
                    <td>${produtos.estoque}</td>
                    <td>${produtos.valor}</td>
                </tr>
             </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="controller?acao=ListaProduto" class="saiba-mais">Mais Informações<i class="fa-solid fa-arrow-right"></i></a>
</div> <!-- Fechar a div pedidos-mensais aqui -->

<div class="dashboard">
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Cobrado</th>
                <th>Pago</th>
                <th>Troco</th>
                <th>Pagamento</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="ultimaVenda" items="${ultimasVendas}"  >
            <tr>
                <th>${ultimaVenda.idVenda}</th>
                <th>${ultimaVenda.valorProduto}</th>
                <th>${ultimaVenda.valorPago}</th>
                <th>${ultimaVenda.trocoValor}</th>
                <th>${ultimaVenda.formaPagento}</th>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>



</body>
</html>