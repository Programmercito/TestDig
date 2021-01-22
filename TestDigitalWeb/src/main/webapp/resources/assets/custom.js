function confirmarget(mensaje, url) {
    var r = confirm(mensaje);
    if (r) {
        window.location = url;
    }
}
