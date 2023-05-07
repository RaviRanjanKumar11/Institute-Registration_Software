package test;
import java.sql.*;

import java.util.*;
public class RetrieveDAO 
{
	public ArrayList<PatientBean> al=new ArrayList<PatientBean>();
	
	public ArrayList<PatientBean>retrieve()
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from hospitaladmin");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PatientBean eb=new PatientBean();
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
				al.add(eb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
