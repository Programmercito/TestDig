function confirmarget(mensaje, url) {
    var r = confirm(mensaje);
    if (r) {
        window.location = url;
    }
}
function goPrevStudent() {
    window.location = "/TestDigitalWeb/student";
}
function goPrevClass() {
    window.location = "/TestDigitalWeb/class";
}
var btn = document.getElementById("backstudent");
if (btn != null) {
    btn.addEventListener("click", goPrevStudent);
}
var btn = document.getElementById("backclass");
if (btn != null) {
    btn.addEventListener("click", goPrevClass);
}
