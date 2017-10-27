package com.bealls.pojo;

public class L1Pojo {

	private String catagoryName,catagorylink;
	private int index;
	public String getCatagoryName() {
		return catagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	public String getCatagorylink() {
		return catagorylink;
	}
	public void setCatagorylink(String catagorylink) {
		this.catagorylink = catagorylink;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getStringL1Catagories(){
		return 
				   "<br>"+this.getIndex()+"  :  "+"<a href="+this.getCatagorylink()+">"+this.getCatagoryName() +"</a>";
	}
}
