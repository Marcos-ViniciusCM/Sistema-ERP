<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/usuario.css">
    <link rel="stylesheet" href="fontawesome/css/all.min.css">
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
        <div class="tabela-usuarios">
            <table>
                <thead>
                 <tr>
                    <th>#</th>
                    <th>Nome </th>
                    <th>Email</th>
                    <th>Perfil</th>
                    <th><a href="AdicionarUsuario.html"><i class="fa-solid fa-plus" ></i></a></th>
                 </tr>
                </thead>
                <tbody>
            <c:forEach var = "user" items="${usuarios}">
                 <tr>
                    <td><img src="https://cdn-icons-png.flaticon.com/512/4210/4210449.png" alt=""></td>
                    <td>${user.nome}</td>
                    <td>${user.email}</td>
                    <td>${user.cargo}</td>
                    <td class="excluir"><a href = "controller?acao=RemoveUsuario&id=${user.id}"><i class="fa-solid fa-user-xmark"></i></i></a></td>
                 </tr>
            </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</body>
</html>