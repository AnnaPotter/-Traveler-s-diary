package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class response_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("        <title>IFPWAFCAD - {местозаполнитель}</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("       <table border=\"0\">\r\n");
      out.write("    <thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th colspan=\"2\">{placeholder}</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><strong>Description: </strong></td>\r\n");
      out.write("            <td><span style=\"font-size:smaller; font-style:italic;\">{placeholder}</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><strong>Counselor: </strong></td>\r\n");
      out.write("            <td>{placeholder}\r\n");
      out.write("                <br>\r\n");
      out.write("                <span style=\"font-size:smaller; font-style:italic;\">\r\n");
      out.write("                member since: {placeholder}</span>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><strong>Contact Details: </strong></td>\r\n");
      out.write("            <td><strong>email: </strong>\r\n");
      out.write("                <a href=\"mailto:{placeholder}\">{placeholder}</a>\r\n");
      out.write("                <br><strong>phone: </strong>{placeholder}\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
