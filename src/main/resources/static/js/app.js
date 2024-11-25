function loadContent(url, linkElement) {
    const contentArea = document.getElementById('mainContent');

    // Exibir mensagem de carregamento
    contentArea.innerHTML = '<div id="loading">Carregando...</div>';

    // Gerenciar o link ativo na barra lateral
    document.querySelectorAll('.sidebar a').forEach(link => link.classList.remove('active'));
    if (linkElement) {
        linkElement.classList.add('active');
    }

    // Buscar o fragmento do servidor
    fetch(`${url}?_=${Date.now()}`) // Evitar cache com timestamp
        .then(response => {
            if (!response.ok) throw new Error('Erro ao carregar o conteúdo.');
            return response.text();
        })
        .then(data => {
            // Substituir o conteúdo da área principal
            contentArea.innerHTML = data;
        })
        .catch(error => {
            contentArea.innerHTML = `<p style="color: red;">Erro ao carregar o conteúdo. Por favor, tente novamente.</p>`;
            console.error('Erro ao carregar fragmento:', error);
        });
}

function submitForm(event, formElement) {
    event.preventDefault(); // Previne o recarregamento da página

    const contentArea = document.getElementById('mainContent');
    const formData = new FormData(formElement);

    // Exibe uma mensagem de carregamento
    contentArea.innerHTML = '<div id="loading">Enviando dados...</div>';

    // Faz a requisição via fetch, garantindo o método POST
    fetch(formElement.action, {
        method: 'POST', // Define explicitamente o método como POST
        body: formData
    })
        .then(response => {
            if (!response.ok) throw new Error('Erro ao enviar dados.');
            return response.text();
        })
        .then(data => {
            // Atualiza o conteúdo principal com a resposta do servidor
            contentArea.innerHTML = data;
            formElement.reset();
        })
        .catch(error => {
            // Exibe uma mensagem de erro
            contentArea.innerHTML = '<p style="color: red;">Erro ao enviar o formulário. Tente novamente.</p>';
            console.error('Erro ao enviar formulário:', error);
        });
        
}