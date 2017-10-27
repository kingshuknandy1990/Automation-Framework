package com.constants.string;

public interface CartPageOnePageCheckoutConstants {

	public static final  String GuestCheckout="//a[contains(text(),'Guest Checkout')]"
			;
	
	
	//---Billing and Shipping Details
	//------------------------------------------
	public static final  String First_Name="firstName",  ///By name
								Last_Name="lastName",
								Street_Address="address1",
								City="city",
								StateOption="state",
								Zip_Code="zipCode",
								Phone_Number="phone1",
								Email_Address="email1",
								Use_Entry="//b[contains(text(),'Use')]",
										continue_to_payment="//button[contains(text(),'continue to payment')]",//xpath
								Edit_Addresss="//a[@id='edit_billing']";
	
	
	public static final String //CardOption = "//form[@id='creditCardForm']//select[@data-title='Please select a <br/> credit card type.']",
								    CardOption ="//select[@id='credit-card-type']",
								    ExpiresOn="//select[@id='credit-card-expMonth']",
								    Year="//select[@id='credit-card-expYear']",
								    CardNo="//input[@id='cc-number']",
								    Security="//input[@id='cvv-number']",
								    continue_to_confirm_order="//button[contains(text(),'continue to confirm order')]",
								    		Place_Order_now="//button[contains(text(),'Place Order now')]"
								    ;


	public static final String useEntry = "//div[@id='use-my-entry-button']//a",
									closesurvey="//div[@class='brdialog-close']",
									billingaddressfeild="//select[@id='billing-address-list']",
									thankUforshopping="//div//h1"
									;


	public static final String userwelcome = "//div[@class='row user-welcome']";


	public static final String confirmorderMsgFeild = "//div[@class='step-body collapse ']//div[@class='review col-lg-12 col-md-12 col-sm-12']//p";


	public static final String accountloginEdit="//div[@class='row user-welcome']//span[@class='edit-step']",
								shippingAndDeliveryEdit="(//div[@class='step-preview']//span[@class='edit-step'])[1]",
								shippingoptionFeild="//select[@id='ShippingAdresslist']"
								;
	
	
	public static final String  accLoginSignIn="//div//a[contains(text(),'Sign In')]",
								accLoginSignInLogon="//form[@class='logon-form']//input[@name='logonId']",
								accLoginSignInPass=	"//form[@class='logon-form']//input[@name='logonPassword']",
								accLoginSignInButton="//form[@class='logon-form']//button"
			;


}
