package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddPatientServlet extends HttpServlet
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
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);			
		}
		else
		{ 
			String fName=c[0].getValue();
			PatientBean eb=new PatientBean();
			eb.setUname(req.getParameter("uname"));
			eb.setPword(req.getParameter("pword"));
			eb.setFname(req.getParameter("fname"));
			eb.setLname(req.getParameter("lname"));
			eb.setAddr(req.getParameter("addr"));
			eb.setMdno(req.getParameter("mdno"));
			eb.setSlno(req.getParameter("slno"));
			eb.setMaid(req.getParameter("maid"));
			eb.setPhno(Long.parseLong(req.getParameter("phno")));
			eb.setLcno(req.getParameter("lcno"));
			int k=new InsertDAO().insert(eb);
			pw.println("Page of Admin:"+fName+"<br>");
			if(k>0)
			{
				pw.print("Employee added sucessfullay..<br>");
				RequestDispatcher rd=req.getRequestDispatcher("admin.html");
				rd.include(req, res);
			}
		}
	}

}
