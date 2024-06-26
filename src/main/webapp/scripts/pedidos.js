function verificaEstado(event) {
    var celulasEstado = document.querySelectorAll('.estado-produto');
    celulasEstado.forEach(function(celula) {
        var valor = celula.textContent.trim().toLowerCase();
        var estado;

        // Verificar se o valor é true ou false e definir o estado correspondente
        if (valor === 'true') {
            estado = 'Concluído';
        } else if (valor === 'false') {
            estado = 'Pendente';
        }

        // Atualizar o texto da célula com o estado correspondente
        celula.textContent = estado;

        // Alterar a cor de fundo com base no estado
        if (estado === 'Concluído') {
            celula.style.backgroundColor = 'LightGreen';
        } else if (estado === 'Pendente') {
            celula.style.backgroundColor = '#FFCCCB';
        }
    });


}

window.onload = verificaEstado;