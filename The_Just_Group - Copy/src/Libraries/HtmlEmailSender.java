package Libraries;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Framework.Main;

 
public class HtmlEmailSender {
	
	public static Resultsummary rs = new Resultsummary();
 
    public void sendHtmlEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // set plain text message
        msg.setContent(message, "text/html");
 
        // sends the e-mail
        Transport.send(msg);
 
    }
 
    /**
     * Test the send html e-mail method
     * @throws Exception 
     *
     */
    public void mail() throws Exception {
        // SMTP server information
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "automation.spi@gmail.com";
        String password = "$picity123";
 
        // outgoing message information
        String mailTo = Main.email;
        String subject = Main.subject;
        
        ProjectSpecific ps = new ProjectSpecific();
		int notRun = ps.rowCount - (Main.pass+Main.fail);
		//Ip address
		InetAddress ownIP=InetAddress.getLocalHost();
		System.out.println("IP of my system is := "+ownIP.getHostAddress());
 
        // message contains HTML markups
      //Date & time
		Calendar currentDate = Calendar.getInstance();
		  SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		  String dateNow = formatter.format(currentDate.getTime());
		  System.out.println("Now the date is :=>  " + dateNow);
		
		String htmlText ="<html><body>"
			+"<p><h1>Test - Automation Execution Result</h1></p>"
			+"<p><h3>Test Suite Executed : "+Main.testSuite+"</h3></p>"
			+"<p><h3>Test Browser  : "+Main.Browser+"</h3></p>"
			+"<p><h3>Execution Date & Time  : "+dateNow+"</h3></p>"
			+ "<table class='summary' width='37%'border='2'>" + "<tr class='title'>"
			+ "<th>Total</th>" + "<th>Pass</th>" + "<th>Fail</th>"
			+ "<th>Not Run</th></tr>"
			+ "<tr align='center'><td>"+ps.rowCount+"</td><td>"+Main.pass+"</td><td>"+Main.fail+"</td><td>"+notRun+"</td></tr></table>"
			+"<table><tr><td><b>Failed Test Script : <td><font color=red>"+Main.failTestScript+"</font></td></td></tr></table>"
			+ "<p><h3>Please find Complete Execution Result @ "+"\\"+"\\"+ownIP.getHostAddress()+"\\Results";

 
        HtmlEmailSender mailer = new HtmlEmailSender();
 
        try {
            mailer.sendHtmlEmail(host, port, mailFrom, password, mailTo, subject, htmlText);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
    }
}