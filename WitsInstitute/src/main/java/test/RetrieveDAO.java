package test;
import java.sql.*;
import java.util.*;
public class RetrieveDAO 
{
	public ArrayList<StudentBean> al=new ArrayList<StudentBean>();
	
	public ArrayList<StudentBean>retrieve()
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from witslogin");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				StudentBean sb=new StudentBean();
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
				al.add(sb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
