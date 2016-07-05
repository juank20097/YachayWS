package yachayws.model.mail.estructura;

import javax.mail.PasswordAuthentication;

public class Authenticator extends javax.mail.Authenticator{
	 private PasswordAuthentication authentication;
	 
     public Authenticator(String username , String password) {
         authentication = new PasswordAuthentication(username, password);
     }
     
     protected PasswordAuthentication getPasswordAuthentication() {
         return authentication;
     }
}
