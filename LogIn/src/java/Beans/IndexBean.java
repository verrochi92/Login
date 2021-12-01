// RegistrationBean class

// JSP bean that handles error messages during registration

// By Nick Verrochi
// Last Modified: 6/28/16
package Beans;

import Business.Login;
import java.io.Serializable;

public class IndexBean implements Serializable {
    private String loginMessage;
    private String regMessage;
    
    // field text (to hold fields in case of error)
    private String loginEmail;
    private String regFirstName;
    private String regLastName;
    private String regEmail;
    
    public IndexBean() {
        loginMessage = "";
        regMessage = "";
        loginEmail = "";
        regFirstName = "";
        regLastName = "";
        regEmail = "";
    }
    
    public void setRegFields(Login login) {
        regFirstName = login.getFirstName();
        regLastName = login.getLastName();
        regEmail = login.getEmail();
    }

    public void clearLoginFields() {
        loginEmail = "";
    }
    
    public void clearRegFields() {
        regFirstName = "";
        regLastName = "";
        regEmail = "";
    }
    
    public void setLoginMessage(String message) {
        this.loginMessage = message;
    }
    
    public String getLoginMessage() {
        String copy = loginMessage;
        loginMessage = "";
        return copy;
    }
    
    public void setRegMessage(String message) {
        this.regMessage = message;
    }
    
    public String getRegMessage() {
        String copy = regMessage;
        regMessage = ""; // to keep message from repeating
        return copy;
    }
    
    public void setLoginEmail(String str) {
        loginEmail = str;
    }
    
    public String getLoginEmail() {
        return loginEmail;
    }
    
    public void setRegFirstName(String str) {
        regFirstName = str;
    }
    
    public String getRegFirstName() {
        return regFirstName;
    }
    
    public void setRegLastName(String str) {
        regLastName = str;
    }
    
    public String getRegLastName() {
        return regLastName;
    }
    
    public void setRegEmail(String str) {
        regEmail = str;
    }
    
    public String getRegEmail() {
        return regEmail;
    }
}
