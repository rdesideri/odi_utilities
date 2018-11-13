import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.MessagingException;


public class SendMail {
        
    private final String user_auth;
    private final String user_password;
    private final String host;
    private final String port;
        
    public SendMail(String user_auth, String user_password, String host, String port){
        this.user_auth = user_auth;
        this.user_password = user_password;
        this.host = host;
        this.port = port;
    }
    
    
    public void SendMail(String to, String Subject, String MessageText) {
        
        
        Properties mailProp = new Properties();
        mailProp.put("mail.smtp.host",host); 
        mailProp.put("mail.smtp.port",port);
        mailProp.put("mail.smtp.starttls.enable","true");
        mailProp.put("mail.smtp.auth","true");
        mailProp.put("mail.smtp.socketFactory.port",port);
        mailProp.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        mailProp.put("mail.smtp.socketFactory.fallback","false");
        mailProp.put("mail.debug", "true");

       
         try {
        Authenticator myAuth = new MyAuthenticator();
        Session session = Session.getDefaultInstance(mailProp,myAuth);
        
        session.setDebug(true);

        MimeMessage mymsg = new MimeMessage(session);
        mymsg.setText(MessageText);
        mymsg.setSubject(Subject);
        mymsg.setFrom(new InternetAddress(user_auth));
        mymsg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        Transport.send(mymsg);
        session.getDebugOut();

         } catch (MessagingException e){
        }
    }



   private class MyAuthenticator extends javax.mail.Authenticator{
      @Override
      public PasswordAuthentication getPasswordAuthentication()
       {
           return new PasswordAuthentication(user_auth, user_password);
       }
   }    
    
}
