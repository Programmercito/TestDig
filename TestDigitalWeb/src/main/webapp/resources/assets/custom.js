function confirmarget(mensaje, url) {
    var r = confirm(mensaje);
    if (r) {
        window.location = url;
    }
}
function goPrev(){ 
   window.history.back() 
}
var btn = document.getElementById("back");
btn.addEventListener("click", goPrev);
