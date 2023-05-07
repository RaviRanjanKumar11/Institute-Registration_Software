package test;
import java.sql.*;
public class InsertDAO 
{
	public int k=0;
	public int insert(PatientBean eb)
	{
		try
		{
		Connection con=DBConnection.getCon();
		
		PreparedStatement ps=con.prepareStatement("insert into hospitaladmin values(?,?,?,?,?,?,?,?,?,?)");
	
		ps.setString(1,eb.getUname());
		ps.setString(2,eb.getPword());
		ps.setString(3,eb.getFname());
		ps.setString(4,eb.getLname());
		ps.setString(5,eb.getAddr());
		ps.setString(6,eb.getMdno());
		ps.setString(7,eb.getSlno());
		ps.setString(8,eb.getMaid());
		ps.setLong(9, eb.getPhno());
		ps.setString(10,eb.getLcno());
		k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;

      }
   }