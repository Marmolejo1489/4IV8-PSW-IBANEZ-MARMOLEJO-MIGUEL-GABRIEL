function soloLetras(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = "áéíóúabcdefghijklmnñopqrstuvwxyz"+"0123456789"+"ÁÉÍÓÚABCDEFGHIJKLMNÑOPQRSTUVWXYZ"+"_.@";
    especiales = "8-37-39-46";

    tecla_especial = false;
    for(var i in especiales){
         if(key === especiales[i]){
             tecla_especial = true;
             break;
         }
     }

     if(letras.indexOf(tecla)===-1 && !tecla_especial){
         return false;
     }
 }

 function validarEmail(email) {

    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if ( !expr.test(email) )
        alert("Error: La dirección de correo " + email + " es incorrecta.");
}


  function validar_clave(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = "abcdefghijklmnopqrstuvwxyz"+"0123456789"+"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"_.@-";
    especiales = "8-37-39-46";

    tecla_especial = false;
    for(var i in especiales){
         if(key === especiales[i]){
             tecla_especial = true;
             break;
         }
     }

     if(letras.indexOf(tecla)===-1 && !tecla_especial){
         return false;
     }
	}

    function valida_envia(){
     
        //el formulario se envia
        alert("Sesión exitosa");
        document.fvalida.submit();
 }
 
 function validarn(e){
    var teclado=(document.all)?e.keyCode:e.which;
    if(teclado===8)return true;

    var patron=/[0-9\d .]/;

    var prueba=String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarIDE(formulario){
    var checkOk="1234567890";
    var idE=formulario.ideliminar.value;
    var allValid=true;
    
    for(var i=0; i<idE.length;i++){
        var ch=idE.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    
    if(idE<0){
        alert("Ingrese un ID válido");
        return false;
    }
}

function validarIDA(formulario){
    var checkOk="1234567890";
    var idA=formulario.idactualizar.value;
    var allValid=true;
    
    for(var i=0; i<idA.length;i++){
        var ch=idA.charAt(i);
        for(var j=0; j<checkOk.length; j++)
        if(ch==checkOk.charAt(j))
            break;
        if(j==checkOk.length){
            allValid=false;
            break;
        }
    }
    
    if(idA<0){
        alert("Ingrese un ID válido");
        return false;
    }
}