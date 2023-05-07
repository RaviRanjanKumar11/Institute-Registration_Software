package test;
import java.sql.*;
import javax.servlet.*;

public class RetrievePatientByCodeDAO 
{
	public PatientBean eb=null;
	public PatientBean retrieve(ServletRequest req)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from hospitaladmin where slno=?");
			ps.setString(1, req.getParameter("slno"));
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				eb=new PatientBean();
				
				eb.setUname(rs.getString(1));
				eb.setPword(rs.getString(2));
				eb.setFname(rs.getString(3));
				eb.setLname(rs.getString(4));
				eb.setAddr(rs.getString(5));
				eb.setMdno(rs.getString(6));
				eb.setSlno(rs.getString(7));
				eb.setMaid(rs.getString(8));
				eb.setPhno(rs.getLong(9));
				eb.setLcno(rs.getString(10));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return eb;
	}
}
