package com.bealls.pojo;

public class L2Pojo {

	private int CouterNo;
	private String CatagoryName,Link;
	public int getCouterNo() {
		return CouterNo;
	}
	public void setCouterNo(int couterNo) {
		CouterNo = couterNo;
	}
	public String getCatagoryName() {
		return CatagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		CatagoryName = catagoryName;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	
	public String toStringUnableToVerify()
	{
		return //  "<p>***********Items added in "+this.getTestCase()+"***********<br>"+
			 //  this.getCouterNo()+"  :  "+this.getCatagoryName()+"<br>"+
			   "<br>"+this.getCouterNo()+"  :  "+"<a href="+this.getLink()+">"+this.getCatagoryName()+"</a>";

		
			
	}
	
}
