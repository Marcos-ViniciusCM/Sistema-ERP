<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/pedido.css">
    <link rel="stylesheet" href="fontawesome/css/all.min.css">
    <script src="scripts/pedidos.js"></script>
    <title>Document</title>
</head>
<body>
    <header>
        <div class="nav-bar">
            <h2>ERP SOFTWARE</h2>
            <ul>

                 <li><a href="controller?acao=DashBoard"> <i class="fa-solid fa-house"></i>Dashboard</a></li>
                 <li><a href="controller?acao=ListaUsuarios"><i class="fa-solid fa-user"></i>Usuario</a></li>
                 <li><a href="controller?acao=ListaProduto"><i class="fa-solid fa-plus"></i>Produtos</a></li>
                 <li><a href="controller?acao=ListaPedido"><i class="fa-solid fa-cart-shopping"></i>Pedidos</a></li>
            </ul>
        </div>
        </header>

    <div class="tabela-pedidos">
        <table>
        <h2>Pedidos</h2>
            <thead>
             <tr>
                <th>Id Pedido</th>
                <th>Nome cliente </th>
                <th>Valor Total</th>
                <th>Forma de pagamento</th>
                <th>Estado</th>
             </tr>
            </thead>
            <tbody>
             <c:forEach var="pedidos" items="${listaVendas}">
             <tr>
                <td>${pedidos.idVenda}</td>
                <td>${pedidos.nomeComprador}</td>
                <td>${pedidos.valorProduto}</td>
                <td>${pedidos.formaPagento}</td>
                <c:if test = "${pedidos.statusVenda == true}">
                    <td id="estado-produto" >Concluido</td>
                </c:if>
                <c:if test = "${pedidos.statusVenda == false}">
                     <td id="estado-produto">Pendente</td>
                </c:if>
             </tr>
             </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>