var main = {
    operacion:null,
    var1:null,
    var2:null,
    jsonResponse:null,
    operar:function(){
        
        text = $("#inpCalc").val();

        if(text.substr(-1) == "+" || text.substr(-1) == "-" || text.substr(-1) == "/" || text.substr(-1) == "*"){
            main.var2 = main.var1;
        }else{
            var positionOper;
            if(main.operacion=="suma"){
               positionOper=text.indexOf("+"); 
            }else if(main.operacion=="resta"){
              positionOper=text.indexOf("-"); 
            }else if(main.operacion=="multiplicacion"){
              positionOper= text.indexOf("*"); 
            }else if(main.operacion=="division"){
               positionOper=text.indexOf("/"); 
            }
            var len = text.length;
            main.var2 = text.slice(positionOper+1,len)
        }
        
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: 'http://localhost:8080/cliente_/SCalculadora',
                data: {
                    value1: main.var1,
                    value2: main.var2,
                    operacion: main.operacion
                },
                success: function (dataR) {
                   // alert("sucess " + dataR);
                    main.jsonResponse = JSON.parse(dataR);
                    $("#inpCalc").val(main.jsonResponse.resultado);
                },
                error: function (e) {
                }
            });
    },
    agregarNum:function(num){
        text = $("#inpCalc").val();
        $("#inpCalc").val(text+""+num);
    },
    agregarOper:function(oper){
        if(oper=='+'){
            main.operacion="suma";
        }else if(oper=='-'){
            main.operacion="resta";
        }else if(oper=='*'){
            main.operacion="multiplicacion";
        }else if(oper=='/'){
            main.operacion="division";
        }
        
        text = $("#inpCalc").val();
        if(text==''){
            text='0';
        }
        if(text.substr(-1)=="+" || text.substr(-1)=="-" || text.substr(-1)=="/" ||text.substr(-1)=="*"){
            var str = text;
            text = str.slice(0,-1);
        }
        main.var1=text;
        $("#inpCalc").val(text+""+oper);
    },
    reset:function(){
        $("#inpCalc").val("");
        main.operacion=null;
        main.var1=null;
        main.var2=null;
    }
}

