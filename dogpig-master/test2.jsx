/*----------------------------------------------------testlogin.html--------------------------- */




function field_focus(field, id){

    if(field.value == id){

        field.value = '';
    }

}

function field_blur(field, id){     /* 외부 클릭했을시 id ,pwd 채워짐 */

    if(field.value == ''){
        field.value = id;
    }

}


