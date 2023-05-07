package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/code")
public class RetrievePatByCode extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		RequestDispatcher rd=req.getRequestDispatcher("code.html");
		rd.include(req, res);
		PatientBean eb=new RetrievePatientByCodeDAO().retrieve(req);
		
		if(eb==null)
		{
			pw.print("<html><head><body><center><h12>");
			pw.print("<br> Invalid Patient Serial no.");
			pw.print("</h12></center></head></body></html>");		
		}
		else
		{			
			pw.print("<html>");
			pw.print("<head><style>\r\n"
					+ "  table,tr {border:1px solid black;background-color:cyan;color:blue;text-align:center;} th{color:red;}"
					+ "  td{border:1px solid red;width:100px;}"
					+ "  th { border:1px solid red;width:100px;}"
					+   "table(margin-left:30%}"
					+ "</style></head></body>");
			pw.print("<center><table>");
			pw.print("<tr><th>UserName</th><th>Password</th><th>FirstName</th><th>LastName</th><th>Address</th><th>MedNo.</th><th>SerialNo.</th><th>EmailID</th><th>ContactNo</th><th>LicenceNo</th>");
						
			pw.print("<tr>\r\n"
					+ "   <td>"+eb.getUname()+"</td>\r\n"
					+ "   <td>"+eb.getPword()+"</td>\r\n"
					+ "   <td>"+eb.getFname()+"</td>\r\n"
					+ "   <td>"+eb.getLname()+"</td>\r\n"
					+ "   <td>"+eb.getAddr ()+"</td>\r\n"
					+ "   <td>"+eb.getMdno ()+"</td>\r\n"
					+ "   <td>"+eb.getSlno ()+"</td>\r\n"
					+ "   <td>"+eb.getMaid ()+"</td>\r\n"
					+ "   <td>"+eb.getPhno ()+"</td>\r\n"
					+ "   <td>"+eb.getLcno ()+"</td>\r\n"
					+ " </tr>\r\n");
		}
	}

}
