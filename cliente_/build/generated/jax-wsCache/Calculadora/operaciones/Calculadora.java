
package operaciones;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Calculadora", targetNamespace = "http://operaciones/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Calculadora {


    /**
     * 
     * @param num1
     * @param num2
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sumar", targetNamespace = "http://operaciones/", className = "operaciones.Sumar")
    @ResponseWrapper(localName = "sumarResponse", targetNamespace = "http://operaciones/", className = "operaciones.SumarResponse")
    @Action(input = "http://operaciones/Calculadora/sumarRequest", output = "http://operaciones/Calculadora/sumarResponse")
    public int sumar(
        @WebParam(name = "num1", targetNamespace = "")
        int num1,
        @WebParam(name = "num2", targetNamespace = "")
        int num2);

    /**
     * 
     * @param num1
     * @param num2
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "multiplicar", targetNamespace = "http://operaciones/", className = "operaciones.Multiplicar")
    @ResponseWrapper(localName = "multiplicarResponse", targetNamespace = "http://operaciones/", className = "operaciones.MultiplicarResponse")
    @Action(input = "http://operaciones/Calculadora/multiplicarRequest", output = "http://operaciones/Calculadora/multiplicarResponse")
    public int multiplicar(
        @WebParam(name = "num1", targetNamespace = "")
        int num1,
        @WebParam(name = "num2", targetNamespace = "")
        int num2);

    /**
     * 
     * @param num1
     * @param num2
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "dividir", targetNamespace = "http://operaciones/", className = "operaciones.Dividir")
    @ResponseWrapper(localName = "dividirResponse", targetNamespace = "http://operaciones/", className = "operaciones.DividirResponse")
    @Action(input = "http://operaciones/Calculadora/dividirRequest", output = "http://operaciones/Calculadora/dividirResponse")
    public int dividir(
        @WebParam(name = "num1", targetNamespace = "")
        int num1,
        @WebParam(name = "num2", targetNamespace = "")
        int num2);

    /**
     * 
     * @param num1
     * @param num2
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "restar", targetNamespace = "http://operaciones/", className = "operaciones.Restar")
    @ResponseWrapper(localName = "restarResponse", targetNamespace = "http://operaciones/", className = "operaciones.RestarResponse")
    @Action(input = "http://operaciones/Calculadora/restarRequest", output = "http://operaciones/Calculadora/restarResponse")
    public int restar(
        @WebParam(name = "num1", targetNamespace = "")
        int num1,
        @WebParam(name = "num2", targetNamespace = "")
        int num2);

}
