<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/produto.css">
    <link rel="stylesheet" href="fontawesome/css/all.min.css">
    <script src="scripts/produtos.js"></script>
    <title>Produtos</title>
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

    <div class="form-produto"  >
        <form class="lista-produtos" action="addProduto" method="POST" >
            <h3><i class="fa-solid fa-palette"></i>Produtos</h3>
            <button id="botaoCadastrarProduto" ><i class="fa-solid fa-plus"></i>Cadastrar produto</button>
            <button  id="botaoListarProduto"  action="listaProdutos"><i class="fa-solid fa-bars"></i>Lista Produto</button>
            <div class="barra" id="barras"></div>
            <div class="cadastroProduto"id="formularioProduto">
            <div id="" >
                <div class="nome-produto">
                    <label for="nome" >Nome</label>
                    <input type="text" id="nome" name="nome" placeholder="Nome*">
                </div>
                <div class="preço-produto">
                    <label for="preço" >Preço</label>
                    <i class="fa-solid fa-brazilian-real-sign"></i>
                    <input type="number" inputmode="numeric" step="any"  id="preço" name="preço" placeholder="0.00">

                </div>
                <div class="estado-produto">
                    <div class="input-estado">
                        <label for="estado" >Estoque</label>
                        <input type="number" id="estado" oninput="validarNumeroInteiro(this)" name = "estoque" placeholder="0" >

                    </div>

                    <button class="botao-adicionar" ><i class="fa-solid fa-file"></i>Adicionar</button>
                </div>
            </div>
        </div>

            <!--Tabela Poduto-->
        <div class="tabela-produtos" id="tabelaProdutos">
            <table>
                <thead>
                 <tr>
                    <th>Nome Produto</th>
                    <th>Valor</th>
                    <th>Estoque Produto</th>
                 </tr>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${produtos}">
                        <tr>
                            <td>${produto.nome}</td>
                            <td>${produto.valor}</td>
                            <td>${produto.estoque}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </form>
    </div>

</body>
</html>