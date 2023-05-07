package test;
import java.sql.*;
import javax.servlet.*;

public class RetrieveStudentByRegnoDAO 
{
	public StudentBean sb=null;
	public StudentBean retrieve(ServletRequest req)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from witslogin where regno=?");
			ps.setString(1, req.getParameter("regno"));
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				sb=new StudentBean();				
				sb.setUname(rs.getString(1));
				sb.setPword(rs.getString(2));
				sb.setFname(rs.getString(3));
				sb.setLname(rs.getString(4));
				sb.setAddr(rs.getString(5));
				sb.setRegno(rs.getString(6));
				sb.setBtchno(rs.getString(7));
				sb.setMaid(rs.getString(8));
				sb.setPhno(rs.getLong(9));
				sb.setBtchtype(rs.getString(10));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sb;
	}
}
