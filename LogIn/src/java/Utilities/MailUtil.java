package Utilities;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {
    
    
    /**Create a default constructor */
    public MailUtil()
    {
        
    }
    
    public static void sendMail(Mail mail)
    {
       
        try{
        //1- Get a mail session
        Properties props = new Properties();
        props.put("mail.transport.protocol","smtps");
        props.put("mail.smtps.host","smtp.gmail.com");//The smtp server is installed in google server
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth","true");
        props.put("mail.smtps.quitwait","false");
        
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        //2- Create a message
        Message message=new MimeMessage(session);
        message.setSubject(mail.getSubject());
        message.setContent(mail.getBody(),"text/html");
        message.setFrom(new InternetAddress(mail.getFrom()));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getTo()));
        
        //3- Send the message 
        Transport transport =session.getTransport();
        transport.connect(mail.getUsername(), mail.getPassword());
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
        
        
        }catch(Exception exception)
        {
            exception.getMessage();
        }
                
        
    }
}
