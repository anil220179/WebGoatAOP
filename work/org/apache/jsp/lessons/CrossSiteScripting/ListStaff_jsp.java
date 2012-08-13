package org.apache.jsp.lessons.CrossSiteScripting;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.owasp.webgoat.session.*;
import org.owasp.webgoat.lessons.CrossSiteScripting.CrossSiteScripting;

public final class ListStaff_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	WebSession webSession = ((WebSession)session.getAttribute("websession"));
	int myUserId = webSession.getUserIdInLesson();

      out.write("\r\n");
      out.write("\t<div class=\"lesson_title_box\"><strong>Welcome Back </strong><span class=\"lesson_text_db\">");
      out.print(webSession.getUserNameInLesson());
      out.write("</span> - Staff Listing Page</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<p>Select from the list below\t</p>\r\n");
      out.write("\t\t<form id=\"form1\" name=\"form1\" method=\"post\" action=\"");
      out.print(webSession.getCurrentLesson().getFormAction());
      out.write("\">\r\n");
      out.write("  <table width=\"60%\" border=\"0\" cellpadding=\"3\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td>  <label>\r\n");
      out.write("  <select name=\"");
      out.print(CrossSiteScripting.EMPLOYEE_ID);
      out.write("\" size=\"11\">\r\n");
      out.write("\t\t\t      \t");

			      	List employees = (List) session.getAttribute("CrossSiteScripting." + CrossSiteScripting.STAFF_ATTRIBUTE_KEY);
			      	Iterator i = employees.iterator();
			      	EmployeeStub stub = (EmployeeStub) i.next();
      out.write("\r\n");
      out.write("\t\t\t      \t<option selected value=\"");
      out.print(Integer.toString(stub.getId()));
      out.write('"');
      out.write('>');
      out.print(stub.getFirstName() + " " + stub.getLastName()+ " (" + stub.getRole() + ")");
      out.write("</option>");

					while (i.hasNext())
					{
						stub = (EmployeeStub) i.next();
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(Integer.toString(stub.getId()));
      out.write('"');
      out.write('>');
      out.print(stub.getFirstName() + " " + stub.getLastName()+ " (" + stub.getRole() + ")");
      out.write("</option>");

					}
      out.write("\r\n");
      out.write("  </select>\r\n");
      out.write("  </label></td>\r\n");
      out.write("      <td>\r\n");
      out.write("\t        \t<input type=\"submit\" name=\"action\" value=\"");
      out.print(CrossSiteScripting.SEARCHSTAFF_ACTION);
      out.write("\"/><br>\r\n");
      out.write("\t        \t<input type=\"submit\" name=\"action\" value=\"");
      out.print(CrossSiteScripting.VIEWPROFILE_ACTION);
      out.write("\"/><br>\r\n");
      out.write("            \t\t");
 
				if (webSession.isAuthorizedInLesson(myUserId, CrossSiteScripting.CREATEPROFILE_ACTION))
				{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" disabled name=\"action\" value=\"");
      out.print(CrossSiteScripting.CREATEPROFILE_ACTION);
      out.write("\"/><br>\r\n");
      out.write("\t\t\t\t");
 
				}
				
      out.write("\r\n");
      out.write("            \t\t");
 
				if (webSession.isAuthorizedInLesson(myUserId, CrossSiteScripting.DELETEPROFILE_ACTION))
				{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"action\" value=\"");
      out.print(CrossSiteScripting.DELETEPROFILE_ACTION);
      out.write("\"/><br>\r\n");
      out.write("\t\t\t\t");
 
				}
				
      out.write("\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"action\" value=\"");
      out.print(CrossSiteScripting.LOGOUT_ACTION);
      out.write("\"/>\r\n");
      out.write("\t  </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("  </table>\r\n");
      out.write("\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
