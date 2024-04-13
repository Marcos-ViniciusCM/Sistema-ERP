
window.onload = function(){
    var botaoCadastrarProduto = document.getElementById("botaoCadastrarProduto");
    var botaoListarProduto = document.getElementById("botaoListarProduto");
    var tabelaProdutos = document.getElementById("tabelaProdutos");
    var formularioProduto = document.getElementById("formularioProduto");
    var barra = document.getElementById("barras");

    botaoListarProduto.addEventListener("click", function() {
        event.preventDefault();
        tabelaProdutos.style.display = "block";
        barra.style.transform = "translateX(200px)"
        formularioProduto.style.display = "none"
    });

    botaoCadastrarProduto.addEventListener("click", function() {
        event.preventDefault();
        tabelaProdutos.style.display = "none";
        barra.style.transform = "translateX(0px)"
        formularioProduto.style.display = "block"
    });
 
  function validarNumeroInteiro(input) {
      // Remove qualquer não número do valor, incluindo vírgulas e pontos
      input.value = input.value.replace(/[^\d]/g, '');
  }
}