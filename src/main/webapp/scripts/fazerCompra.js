window.onload = function() {
    function calcularValorMinimo() {
        var valorProduto = parseFloat(document.getElementById("valor").textContent);
        var quantidade = parseInt(document.getElementById("quantidade").value);
        var resultado = quantidade * valorProduto;
        var minimo = parseFloat(document.getElementById("valorPago").value);

        if (minimo < resultado) {
            // Envie o formulário se o valor mínimo nao for atingido
            alert("O valor mínimo não foi atingido.");
             document.forms['frmCompra'].valorPago.focus();
			 return false;
        } else {
            document.forms['frmCompra'].submit();
        }
    }

    // Adicionando um ouvinte de evento ao botão
    document.getElementById("botao").addEventListener("click", calcularValorMinimo);
}