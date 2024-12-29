const forms = document.getElementsByTagName("form");

for (const form of forms) {
    form.addEventListener("keydown", function (event) {
        if (event.key === "Enter") { // Verifica se a tecla pressionada é Enter
            event.preventDefault(); // Evita o comportamento padrão
        }
    });
}

