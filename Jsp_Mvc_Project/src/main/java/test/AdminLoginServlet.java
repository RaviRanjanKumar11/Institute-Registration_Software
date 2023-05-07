package test;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		AdminBean ab=new AdminLoginDAO().login(req);
		if(ab==null)
		{
			req.setAttribute("msg","invalid login process<br>");
			RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
			rd.forward(req, res);
		}
		else
		{
			HttpSession hs=req.getSession();
			 hs.setAttribute("abean", ab);
			 
	       RequestDispatcher rd=req.getRequestDispatcher("link.html");
	       rd.forward(req, res);
		}
	}

}
