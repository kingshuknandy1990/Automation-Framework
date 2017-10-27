package com.constants.string;

public interface PromotionConstants {

	public static int cellno = 1;
	public static String TestData = "TestData",
						PromoSheet="PromoSheet",
								filepath=System.getProperty("user.dir")+"\\Bealls_Execution_Excel.xlsx";
	public static String CheckOutInPDP ="//div[@class='container-fluid']/div/div[2]/div[2]/a";
	public static String EstimatedTax = "//div[@id='total-tax']";
	/**
	 *Search Field constants
	 *Elements located by id 
	 */
	public static final String SEARCHBOX ="SimpleSearchForm_SearchTerm" ,SEARCHBUTTON="search-btn" ;
	
	
	/**
	 *Search Field constants
	 *Elements located by Xpath 
	 */
	public static final String Product="(//div[@class='item-image match-height-element'])[1]";
	
	public static final  String  Sizemedium="//div[@id='attribute-Size']//ul//li[1]//a";
	public static final  String   AddtoCartBtnPDP="//div[@id='addToCartBtnPDP']//a";
	public static final  String   CheckOutPopup="//div//a[@class='checkout-button btn-checkout']";
	public static final  String   RandomProduct="(//div[@class='item-image match-height-element'])[2]";
	public static final  String    SecureCheckOutBtn="//div[@id='checkout-button']";
	public static final  String ContinueAsGuestinCheckOutPage="//a[contains(text(),'Continue')]";
	
	
	//---Billing and Shipping Details
	//------------------------------------------
	public static final  String First_Name="(//input[@name='firstName'])[2]",
								Last_Name="(//input[@name='lastName'])[2]",
								Street_Address="(//input[@name='address1'])[2]",
								City="(//input[@name='city'])[2]",
								StateOption="//form[@id='addAddressForm_Billing']//select",
								Zip_Code="(//input[@name='zipCode'])[2]",
								Phone_Number="(//input[@name='fakePhone1Part1'])[2]",
								Email_Address="(//input[@name='email1'])[2]",
								Use_Entry="//b[contains(text(),'Use')]",
								ContinueChekOut="(//a[contains(text(),'CONTINUE CHECKOUT')])[2]",
								Edit_Addresss="//a[@id='edit_billing']";
								
								
	//---Card Details     //select[@name='paymentMethod']
		//------------------------------------------
	public static final String //CardOption = "//form[@id='creditCardForm']//select[@data-title='Please select a <br/> credit card type.']",
	                           CardOption ="//select[@name='paymentMethod']",
							   ExpiresOn="(//form[@id='creditCardForm']//select)[2]",
			                   Year="(//form[@id='creditCardForm']//select)[3]",
			                   CardNo="(//form[@id='creditCardForm']//input)[1]",
			                   Security="(//form[@id='creditCardForm']//input)[2]",
			                   CompleteYourOrder="(//a[contains(text(),'COMPLETE YOUR ORDER')])[1]";
			                   ;
	 public static final String orderConfimationFeild="//h1[contains(text(),'Thank you for shopping at BeallsFlorida.com')]";
   //Promotion Code Cheker feilds
	//------------------------
	public static final String PromoErrorFeild="//div[@id='promotionBlankError']//font",
			                   PromoCodeFeild="(//input[@id='promoCode'])[1]",
			                   PromoApplyButton="//form[@id='PromotionCodeForm']//div//div[2]",
			                  
			                   AppliedPromotionName="//div[@class='promotion_used table']//a[@class='Pname']",
			                   PromoRemoveFeild="//div[@class='promotion_used table']//a[@class='icon-closex']",
			                   AppliedPromoDiscountValue="//div[@class='promotion_used table']//span[@class='discountAmout']",
			                   
			                   PromoAppliedFeild="//div[@id='promo-discount']",
			                   DeductedPriceFeild="//div[@id='promo-discount']//div[2]",
			                   ProductSubtotal="//div[@id='total-subtotal']"
			                   ;
	
	

	public static final String Quantity = "//select[@id='quantity']";

	public static final String ShippingChargefeild = "//div[@id='total-shipping']",
								EstimatedTotal="//div[@id='total-total']"
								
			;
	
	//--------------Excell columnrow no for inputs
	public static final int mainCatagoryRow=4,
							sizeRow=19,
							subCatagoryRow=20,
									
									FirstNameRow=35,
									LastNameRow=36,
									StreetAddressRow=37,
									CityRow=38,
									StateRow=39,
									ZipRow=40,
									PhoneRow=41,
									EmailRow=42,

									CardTypeRow=29,
									CardNumberRow=30,
									Security11Row=31,
									ExpiresOnRow=32,
									Year11Row=33,
	                                
									
									PromotionNameRowCart=44,
	                                PromoCodeRowCart=45,
									PromotionNameRowShipBill=46,
									PromoCodeRowShipBill=47,
									PromotionNameRowPay=48,
									PromoCodeRowPay=49;
	

}
