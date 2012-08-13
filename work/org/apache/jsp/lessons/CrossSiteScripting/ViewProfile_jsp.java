package org.apache.jsp.lessons.CrossSiteScripting;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.owasp.webgoat.session.*;
import org.owasp.webgoat.lessons.CrossSiteScripting.CrossSiteScripting;

public final class ViewProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--\r\n");
      out.write("STAGE 4 FIXES Look for the <-- STAGE 4 - FIX\r\n");
      out.write("-->\r\n");
      out.write("\r\n");

WebSession webSession = ((WebSession)session.getAttribute("websession"));
	Employee employee = (Employee) session.getAttribute("CrossSiteScripting." + CrossSiteScripting.EMPLOYEE_ATTRIBUTE_KEY);
	CrossSiteScripting lesson = (CrossSiteScripting) webSession.getCurrentLesson();
//	int myUserId = getIntSessionAttribute(webSession, "CrossSiteScripting." + CrossSiteScripting.USER_ID);

      out.write("\r\n");
      out.write("\t\t<div class=\"lesson_title_box\"><strong>Welcome Back </strong><span class=\"lesson_text_db\">");
      out.print(webSession.getUserNameInLesson());
      out.write("</span></div>\r\n");
      out.write("\t\t<div class=\"lesson_text\">\r\n");
      out.write("\t\t\t\t<Table>\r\n");
      out.write("\t\t\t\t<TR><TD>\r\n");
      out.write("\t\t\t\t\t\tFirst Name:\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getFirstName());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tLast Name:\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t \t");
      out.print(employee.getLastName());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t<TR><TD>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tStreet: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t<!-- STAGE 4 - FIX  Note that the description value below gets encoded and address1 here is not -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getAddress1());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tCity/State: \r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getAddress2());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t<TR><TD>\r\n");
      out.write("\t\t\t\t\t\tPhone: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getPhoneNumber());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tStart Date: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getStartDate());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t<TR><TD>\r\n");
      out.write("\t\t\t    \t\tSSN: \r\n");
      out.write("\t\t\t    \t</TD>\r\n");
      out.write("\t\t\t    \t<TD>\r\n");
      out.write("\t\t\t    \t\t");
      out.print(employee.getSsn());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tSalary: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getSalary());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t<TR><TD>\r\n");
      out.write("\t\t\t\t\t\tCredit Card: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getCcn());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tCredit Card Limit: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getCcnLimit());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t<TR><TD>\r\n");
      out.write("\t\t\t\t\t\tComments: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t<!-- Encode data that might contain HTML content to protect against XSS -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(lesson.htmlEncode(webSession, employee.getPersonalDescription()));
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tManager: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getManager());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\t\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t<TR><TD>\r\n");
      out.write("\t\t\t\t\t\tDisciplinary Explanation: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getDisciplinaryActionNotes());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tDisciplinary Action Dates: \r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(employee.getDisciplinaryActionDate());
      out.write("\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t</Table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"lesson_buttons_bottom\">\r\n");
      out.write("\t\t    <table width=\"460\" height=\"20\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                 <tr>\r\n");
      out.write("                 \t<td width=\"50\">\r\n");
      out.write("\t\t\t\t\t");
					
					if (webSession.isAuthorizedInLesson(webSession.getUserIdInLesson(), CrossSiteScripting.LISTSTAFF_ACTION))
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<form method=\"POST\" action=\"");
      out.print(webSession.getCurrentLesson().getFormAction());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"");
      out.print(CrossSiteScripting.EMPLOYEE_ID);
      out.write("\" value=\"");
      out.print(employee.getId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"action\" value=\"");
      out.print(CrossSiteScripting.LISTSTAFF_ACTION);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t</form></td>\r\n");
      out.write("\t\t\t\t\t");
 
					}
					
      out.write("\t\t\t\r\n");
      out.write("\t\t             <td width=\"50\">\r\n");
      out.write("\t\t\t\t\t");
					
					if (webSession.isAuthorizedInLesson(webSession.getUserIdInLesson(), CrossSiteScripting.EDITPROFILE_ACTION))
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<form method=\"POST\" action=\"");
      out.print(webSession.getCurrentLesson().getFormAction());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"");
      out.print(CrossSiteScripting.EMPLOYEE_ID);
      out.write("\" value=\"");
      out.print(employee.getId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"action\" value=\"");
      out.print(CrossSiteScripting.EDITPROFILE_ACTION);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t");
 
					}
					
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("                    <td width=\"60\">\r\n");
      out.write("\t\t\t\t\t");

					if (webSession.isAuthorizedInLesson(webSession.getUserIdInLesson(), CrossSiteScripting.DELETEPROFILE_ACTION))
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<form method=\"POST\" action=\"");
      out.print(webSession.getCurrentLesson().getFormAction());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"");
      out.print(CrossSiteScripting.EMPLOYEE_ID);
      out.write("\" value=\"");
      out.print(employee.getId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"action\" value=\"");
      out.print(CrossSiteScripting.DELETEPROFILE_ACTION);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t");
 
					}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("                      <td width=\"190\">&nbsp;</td>\r\n");
      out.write("                      <td width=\"76\">\r\n");
      out.write("\t\t\t\t\t\t<form method=\"POST\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"action\" value=\"");
      out.print(CrossSiteScripting.LOGOUT_ACTION);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("         \t</table>\r\n");
      out.write("\t\t</div>\r\n");
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
