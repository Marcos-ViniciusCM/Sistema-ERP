<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/compra.css">
    <title>Compra de Objetos</title>
    <script src="scripts/fazerCompra.js"></script>
</head>
<body>

    <div class="container">
        <h1>Compra de Objetos</h1>
        <form  name="frmCompra" id="formularioCompra" action="fazerCompra" method="POST">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="nameComprador" required>
            <table>
                <thead>
                    <tr>
                        <th>Id Produto</th>
                        <th>Objeto</th>
                        <th>Quantidade</th>
                        <th>Tipo de Pagamento</th>
                        <th>Valor (R$)</th>
                        <th>Estoque Disponível</th>
                        <th>Troco para</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="produto" items="${ListaProdutos}">
                        <tr>
                            <td><input type="hidden" name="idProduto" value="${produto.produtoId}"></td>
                            <td>${produto.nome}</td>
                            <td><input type="number" name="quantidade" value = "0"id="quantidade" min="0"></td>
                            <td>
                                <select name="metodo-pagamento" id="metodo-pagamento">
                                    <option value="credito">Cartão de Crédito</option>
                                    <option value="debito">Cartão de Débito</option>
                                    <option value="dinheiro">Dinheiro</option>
                                    <option value="Pix">Pix</option>
                                </select>
                            </td>
                            <td id="valor" name="valorProduto">${produto.valor}</td>
                            <td id="estoque" name="estoque">${produto.estoque}</td>
                            <td><input type="number" value="0" name="valorPago" id="valorPago" step="0.01"></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button type="submit"id="botao" onclick="return validarCompra()">Enviar</button>
        </form>

    </div>

</body>
</html>