package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddStudentServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[] =req.getCookies();
		
		if(c==null)
		{
			pw.print("Session expired please login again <br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);			
		}
		else
		{ 
			String fName=c[0].getValue();
			StudentBean sb=new StudentBean();
			sb.setUname(req.getParameter("uname"));
			sb.setPword(req.getParameter("pword"));
			sb.setFname(req.getParameter("fname"));
			sb.setLname(req.getParameter("lname"));
			sb.setAddr(req.getParameter("addr"));
			sb.setRegno(req.getParameter("regno"));
			sb.setBtchno(req.getParameter("btchno"));
			sb.setMaid(req.getParameter("maid"));
			sb.setPhno(Long.parseLong(req.getParameter("phno")));
			sb.setBtchtype(req.getParameter("btchtype"));
			int k=new InsertDAO().insert(sb);
			pw.println("Page of Student:"+fName+"<br>");
			if(k>0)
			{
				pw.print("Student added sucessfullay..<br>");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
		}
	}

}
