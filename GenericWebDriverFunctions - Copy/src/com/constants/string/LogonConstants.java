package com.constants.string;


/**
 * This class contains all element locators of LogonPage 
 * which all are String  constants. In case of any changes in
 * the LogonPage this class needs an update if needed.
 * 
 * @author skandakumar.v
 *
 */
public class LogonConstants {

	//Elements located by name
	public static final String EADDRESS="logonId", PASSWORD="logonPassword";
	
	//Elements located by XPath
	public static final String LOGIN="//div[@id='sign-in']/button",SIGNIN="//div[contains(@class,'sign-in')]/a[1]",SIGNINOPC="//a[contains(@class,'checkout-sign-in')]",
			LOGINOPC="//button[contains(@data-user-action,'logon')]";
	
	
}
