package test;
import java.sql.*;
public class InsertDAO 
{
	public int k=0;
	public int insert(StudentBean sb)
	{
		try
		{
		Connection con=DBConnection.getCon();
		
		PreparedStatement ps=con.prepareStatement("insert into witslogin values(?,?,?,?,?,?,?,?,?,?)");
	
		ps.setString(1,sb.getUname());
		ps.setString(2,sb.getPword());
		ps.setString(3,sb.getFname());
		ps.setString(4,sb.getLname());
		ps.setString(5,sb.getAddr());
		ps.setString(6,sb.getRegno());
		ps.setString(7,sb.getBtchno());
		ps.setString(8,sb.getMaid());
		ps.setLong(9, sb.getPhno());
		ps.setString(10,sb.getBtchtype());
		k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;

      }
   }