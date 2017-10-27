package com.bealls.pojo;

public class PromotionPojo {

	private String promotionName,promoCode;

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	public String toStringPromo()
	{
		return "<style>"+
				"P   {color: blue;}"+
				"</style>"+
			   "<br>"+"<p>Promotion Name  : "+this.getPromotionName()+"&nbsp;&nbsp;&nbsp;&nbsp;Promo-Code  :  "+this.getPromoCode()+"</p>";

		
			
	}
}
