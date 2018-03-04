package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Calculadora</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Calculadora</h1>\n");
      out.write("        \n");
      out.write("        <form action=\"SCalculadora\" method=\"post\">\n");
      out.write("            <input type=\"text\" name=\"var1\" id=\"var1\"/>\n");
      out.write("            <input type=\"text\" name=\"var2\" id=\"var2\"/>\n");
      out.write("            <input type=\"button\" name=\"btnSumar\" value=\"+\"/>\n");
      out.write("            <input type=\"button\" name=\"btnRestar\" value=\"-\"/>\n");
      out.write("            <input type=\"button\" name=\"btnDividir\" value=\"/\"/>\n");
      out.write("            <input type=\"button\" name=\"btnMultiplicar\" value=\"*\"/>\n");
      out.write("            <input type=\"submit\" name=\"btnIgual\" value=\"=\"/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("            ");
      out.write("<hr/>\n");
      out.write("    ");

    try {
	operaciones.Calculadora_Service service = new operaciones.Calculadora_Service();
	operaciones.Calculadora port = service.getCalculadoraPort();
	int num1 = Integer.parseInt(request.getParameter("var1"));
	int num2 = Integer.parseInt(request.getParameter("var2"));
        int result = 0;
	// TODO process result here
        if(request.getParameter("btnSumar")!=null){
            result = port.sumar(num1, num2);
        }else if(request.getParameter("btnRestar")!=null){
                result = port.restar(num1, num2);
        }else if(request.getParameter("btnDividir")!=null){
                result = port.dividir(num1, num2);
        }else if(request.getParameter("btnMultiplicar")!=null){
                result = port.multiplicar(num1, num2);
        }
        out.println("<div id='result'>"+"= "+result+"</div>");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    
      out.write("\n");
      out.write("    ");
      out.write("<hr/>\n");
      out.write("    </body>\n");
      out.write("   \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
