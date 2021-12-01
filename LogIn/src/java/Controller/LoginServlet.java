// Login Servlet

// Handles logging in to user account

// By Nick Verrochi
// Last Modified: 6/24/16
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.IndexBean;
import Data.ConnectToDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("loginEmail").trim();
        String password = request.getParameter("loginPassword").trim();
        
        IndexBean bean = (IndexBean)request.getSession().getAttribute("indexBean");
        bean.setLoginEmail(email);
        
        // check if in database
        if (isValidUser(email, password)) {
            // go to next page
            bean.setLoginMessage("Success!");
        }
        else {
            // generate error
            bean.setLoginMessage("Unable to login! Please try again!");
        }
        
        String url = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    private boolean isValidUser(String email, String password) {
        try {
            ConnectToDB connect = new ConnectToDB();
            ResultSet resultSet = connect.getStm().executeQuery("SELECT * "
                    + "FROM userinfo WHERE email = \'" + email + "\' AND "
                    + "password = \'" + password + "\';"
            );
            return resultSet.next();
        }
        catch(SQLException e) {
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
