package Controller;

import Business.Login;
import Beans.IndexBean;
import Utilities.Mail;
import Utilities.MailUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Yassine
 */
public class RegistrationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {

        //Connect to The DB
        ConnectToDB connect = new ConnectToDB();

        String firstName = request.getParameter("regFirstName").trim();
        String lastName = request.getParameter("regLastName").trim();
        String email = request.getParameter("regEmail").trim();
        String Password = request.getParameter("regPassword");
        String confirmPassword = request.getParameter("regConfirmPassword");
        GregorianCalendar dob = pullDate(request);
        
        // pull field entries and bean for validation
        Login login = new Login(firstName, lastName, email, Password, confirmPassword, dob);
        IndexBean bean = (IndexBean) request.getSession().getAttribute("indexBean");
        bean.setRegFields(login);

        RegistrationValidator validator = new RegistrationValidator(login, bean, connect);

        String url = "/index.jsp";

        if (validator.validate()) {
            RegistrationIO regi = new RegistrationIO();
            regi.setUsertInfo(connect, login); //Save user info record to the DB
            bean.setRegMessage("Registration successful! Please check your email to activate your account!");
            bean.clearRegFields();
            sendActivationEmail(connect, login);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // pulls date from form and stores as a GregorianCalendar
    public GregorianCalendar pullDate(HttpServletRequest request) {
        GregorianCalendar dob;
        
        int year = Integer.parseInt(request.getParameter("DOBYear"));
        int month = Integer.parseInt(request.getParameter("DOBMonth"));
        int day = Integer.parseInt(request.getParameter("DOBDay"));
        
        dob = new GregorianCalendar(year, month, day);
        
        return dob;
    }
    
    // sends confirmation email to user
    public void sendActivationEmail(ConnectToDB connect, Login login) {
        final String subject = "Account activation";

        final String body = "Please click here to activate your account: "
                + "<a href=\"http://localhost:8084/Test/activate.jsp?id="
                + login.getID(connect) + "\">Activate!</a>";

        Mail mail = new Mail("partyapp.registrar@gmail.com", "partyapp.registrar", "party617",
                login.getEmail(), subject, body);
        MailUtil.sendMail(mail);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }
}
