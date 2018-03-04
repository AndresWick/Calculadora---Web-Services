/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Carlos Aguirre.
 */
@WebService(serviceName = "Calculadora")
public class Calculadora {

    /**
     * Método que permite sumar dos números.
    */
    @WebMethod(operationName = "sumar")
    public int sumar(@WebParam(name = "num1") int num1,@WebParam(name = "num2") int num2) {
        return num1+num2;
    }
    
    /**
     * Método que permite restar dos números.
    */
    @WebMethod(operationName = "restar")
    public int restar(@WebParam(name = "num1") int num1,@WebParam(name = "num2") int num2) {
        return num1-num2;
    }
    
    /**
     * Método que permite multiplicar dos números.
    */
    @WebMethod(operationName = "multiplicar")
    public int multiplicar(@WebParam(name = "num1") int num1,@WebParam(name = "num2") int num2) {
        return num1*num2;
    }
    
    /**
     * Método que permite dividir dos números.
    */
    @WebMethod(operationName = "dividir")
    public int dividir(@WebParam(name = "num1") int num1,@WebParam(name = "num2") int num2) {
        return num1/num2;
    }
    
}
