package Utilities;


public class Mail {
    
    private String from;
    private String username;
    private String password;
    private String to;
    private String subject;
    private String body;

    public Mail()
    {
        
    }
    
    public Mail(String from, String username, String password, String to, String subject, String body) {
        this.from = from;
        this.username = username;
        this.password = password;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
    
}
