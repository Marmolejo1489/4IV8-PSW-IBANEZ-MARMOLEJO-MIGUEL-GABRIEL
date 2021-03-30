/*
Creación de una función encargada de validar
la entrada de números mediante una expresión regular.
*/

function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}


function interes(){
    var valor = document.formulario.cantidad.value;
    var valorb = document.formulario.cantidadb.value;
    var result = parseInt(valor);
    var resultb = parseInt(valorb);
    var edad = result - resultb;

    document.formulario.sueldoti.value = edad + " años.";
}

function borrar(){
    document.formulario.cantidad.value = "";
    document.formulario.cantidadb.value = "";
    document.formulario.sueldoti.value = "";
}