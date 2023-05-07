package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Cookie c[] =req.getCookies();
		
		if(c==null)
		{
			pw.print("<html><head><body><center><h10>");
			pw.print("session expired please login again<br>");
			pw.print("</h10></center></head></body></html>");
		}
		else
		{
			c[0].setMaxAge(0);
			pw.print("<html><head><body><center><h10>");	
			pw.print("Student Loggedout Sucess<br>");
			pw.print("</h10></center></head></body></html>");
		}
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, res);
	}
}
