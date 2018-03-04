/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import operaciones.Calculadora_Service;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

/**
 *
 * @author usuario
 */
@WebServlet(urlPatterns = {"/SCalculadora"})
public class SCalculadora extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/calculadora_/Calculadora.wsdl")
    private Calculadora_Service service;

   /* private ObjectMapper jsonMapper = new ObjectMapper();
    private ArrayNode arrayNode = jsonMapper.createArrayNode();


    @Override
    public void init() throws ServletException {
        this.jsonMapper = new ObjectMapper();
        this.arrayNode = jsonMapper.createArrayNode();
    }*/
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
           ObjectMapper jsonMapper = new ObjectMapper();
        
                ObjectNode objectNode = jsonMapper.createObjectNode();
                int a = Integer.parseInt(request.getParameter("value1"));
                int b = Integer.parseInt(request.getParameter("value2"));
                String oper = request.getParameter("operacion");
                objectNode.put("value1", a );
                objectNode.put("value2", b);
                objectNode.put("operacion", request.getParameter("operacion"));
               System.out.println(oper);
                if (oper.equals("suma")) {
                    objectNode.put("resultado",  sumar(a,b));
                }else if(oper.equals("resta")){
                   objectNode.put("resultado",  restar(a,b));
                }else if(oper.equals("multiplicacion")){
                    objectNode.put("resultado",  multiplicar(a,b));
                }else if(oper.equals("division")){
                    if(b==0){
                        objectNode.put("resultado",  "Math Error");
                    }else{
                        objectNode.put("resultado",  dividir(a,b));
                    }
                }
                jsonMapper.writeValue(response.getWriter(), objectNode);
            
  
      
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private int sumar(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        operaciones.Calculadora port = service.getCalculadoraPort();
        return port.sumar(num1, num2);
    }

    private int restar(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        operaciones.Calculadora port = service.getCalculadoraPort();
        return port.restar(num1, num2);
    }

    private int multiplicar(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        operaciones.Calculadora port = service.getCalculadoraPort();
        return port.multiplicar(num1, num2);
    }

    private int dividir(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        operaciones.Calculadora port = service.getCalculadoraPort();
        return port.dividir(num1, num2);
    }

}
