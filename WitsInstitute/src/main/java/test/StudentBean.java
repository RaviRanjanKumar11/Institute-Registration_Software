package test;
import java.io.*;
@SuppressWarnings("serial")
public class StudentBean implements Serializable 
{
	private String uname,pword,fname,lname,addr,regno,btchno,maid,btchtype;
	private Long phno;
	
	public StudentBean()
	{}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getBtchno() {
		return btchno;
	}

	public void setBtchno(String btchno) {
		this.btchno = btchno;
	}

	public String getMaid() {
		return maid;
	}

	public void setMaid(String maid) {
		this.maid = maid;
	}

	public String getBtchtype() {
		return btchtype;
	}

	public void setBtchtype(String btchtype) {
		this.btchtype = btchtype;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}	
}
