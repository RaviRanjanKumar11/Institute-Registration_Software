package test;
import java.sql.*;

import javax.servlet.http.*;
public class AdminLoginDAO 
{
	public AdminBean ab=null;
	public AdminBean login(HttpServletRequest req)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from admin where uname=? and pword=?");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2,req.getParameter("pword"));
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				ab=new AdminBean();
				ab.setFName(rs.getString(1));
				ab.setpWord(rs.getString(2));
				ab.setFName(rs.getString(3));
				ab.setLName(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setmId(rs.getString(6));
				ab.setPhNo(rs.getLong(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return ab;
		}
	}
