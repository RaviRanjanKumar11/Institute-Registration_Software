package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")
public class StudentLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String fName=new LoginDAO().login(req);
		
		if(fName==null)
		{
			pw.print("<html><body><head><style>h9{color:green;}</style><center><marquee><h9>");
			pw.print(" Invalid   User  /  Password   .  .  .  <br>");
			pw.print("</marquee></center></head></body></html>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			Cookie ck=new Cookie("fName",fName);		
			res.addCookie(ck);
			pw.print("<html><body><head><style>h9{color:DarkBlue;}</style><center><marquee><h9>");
			pw.println("Welcome Student @ "+fName+"<br>");
			pw.print("</marquee></center></head></body></html>");
			
			RequestDispatcher rd=req.getRequestDispatcher("hiitstatus.html");
			rd.include(req, res);
		}
	}
}