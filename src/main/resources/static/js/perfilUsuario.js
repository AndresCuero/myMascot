document.addEventListener('DOMContentLoaded', function () {
    var successMessageContainer = document.getElementById('successMessageContainer');
    var successMessage = document.getElementById('successMessage');

    // Mostrar el mensaje de éxito con animación
    if (successMessageContainer && successMessage) {
        successMessageContainer.style.display = 'block'; // Mostrar el contenedor
        successMessage.classList.add('show');

        setTimeout(function () {
            successMessage.classList.remove('show');
            setTimeout(function () {
                successMessageContainer.style.display = 'none'; // Ocultar el contenedor
            }, 300); // Asegura que la animación de salida termine antes de ocultar
        }, 10000); // Mostrar durante 10 segundos
    }
});