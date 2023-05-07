package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewStudentServlet extends GenericServlet
{
	public RetrieveDAO ob=null;
	public void init()throws ServletException
	{
		ob=new RetrieveDAO();
	}
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ArrayList<StudentBean> al=new RetrieveDAO().retrieve();
		
		if(al.size()==0)
		{
			pw.print("Student is not Available <br>");			
		}
		else
		{
			Iterator<StudentBean> sp=al.iterator();
			
			
			pw.print("<html>");
			pw.print("<head><style>\r\n"
					+ "  table,tr {border:1px solid black;background-color:cyan;color:red;text-align:center;} th{color:red;}"
					+ "  td{border:1px solid red;width:100px;}"
					+ "  th { border:1px solid red;width:100px;}"
					+   "table(margin-left:30%}"
					+ "</style></head></body>");
			pw.print("<table>");
			pw.print("<tr><th>UserName</th><th>Password</th><th>FirstName</th><th>LastName</th><th>Address</th><th>RegNo.</th><th>BtchNo.</th><th>EmailID</th><th>ContactNo</th><th>Btchtype</th>");
			
			while(sp.hasNext()) 
			{
				
				StudentBean sb=(StudentBean)sp.next();
				
				pw.print("<tr>\r\n"
				+ "   <td>"+sb.getUname()+"</td>\r\n"
				+ "   <td>"+sb.getPword()+"</td>\r\n"
				+ "   <td>"+sb.getFname()+"</td>\r\n"
				+ "   <td>"+sb.getLname()+"</td>\r\n"
				+ "   <td>"+sb.getAddr()+"</td>\r\n"
				+ "   <td>"+sb.getRegno()+"</td>\r\n"
				+ "   <td>"+sb.getBtchno()+"</td>\r\n"
				+ "   <td>"+sb.getMaid()+"</td>\r\n"
				+ "   <td>"+sb.getPhno ()+"</td>\r\n"
				+ "   <td>"+sb.getBtchtype ()+"</td>\r\n"
				+ " </tr>\r\n");		
			}
			pw.print("</table><br><br>");
			
		}
		RequestDispatcher rd=req.getRequestDispatcher("link.html");
		rd.include(req, res);	
	}
}
