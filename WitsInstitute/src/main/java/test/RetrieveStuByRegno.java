package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/rg")
public class RetrieveStuByRegno extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		RequestDispatcher rd=req.getRequestDispatcher("regno.html");
		rd.include(req, res);
		StudentBean sb=new RetrieveStudentByRegnoDAO().retrieve(req);
		
		if(sb==null)
		{
			pw.print("<html><head><body><center><h4>");
			pw.print("<br> Invalid Student Reg no.");
			pw.print("</h4></center></head></body></html>");
		}
		else
		{			
			pw.print("<html>");
			pw.print("<head><style>\r\n"
					+ "  table,tr {border:1px solid black;background-color:GreenYellow;color:red;text-align:center;} th{color:red;}"
					+ "  td{border:1px solid red;width:100px;}"
					+ "  th { border:1px solid red;width:100px;}"
					+   "table(margin-left:30%}"
					+ "</style></head></body>");
			pw.print("<center><table>");
			pw.print("<tr><th>UserName</th><th>Password</th><th>FirstName</th><th>LastName</th><th>Address</th><th>Regno.</th><th>BatchNo</th><th>EmailID</th><th>ContactNo</th><th>Batchtype</th>");
						
			pw.print("<tr>\r\n"
					+ "   <td>"+sb.getUname()+"</td>\r\n"
					+ "   <td>"+sb.getPword()+"</td>\r\n"
					+ "   <td>"+sb.getFname()+"</td>\r\n"
					+ "   <td>"+sb.getLname()+"</td>\r\n"
					+ "   <td>"+sb.getAddr ()+"</td>\r\n"
					+ "   <td>"+sb.getRegno ()+"</td>\r\n"
					+ "   <td>"+sb.getBtchno ()+"</td>\r\n"
					+ "   <td>"+sb.getMaid ()+"</td>\r\n"
					+ "   <td>"+sb.getPhno ()+"</td>\r\n"
					+ "   <td>"+sb.getBtchtype ()+"</td>\r\n"
					+ " </tr>\r\n");
		}
	}

}
