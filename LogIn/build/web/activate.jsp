<%-- 
    Document   : activate
    Created on : Jun 15, 2016, 6:30:49 PM
    Author     : Nicholas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<jsp:useBean id="activationBean" class="Beans.ActivationBean" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Activation</title>
    </head>
    <body>
        <% activationBean.activate(request); %>
        <p>Account has been activated!</p>
    </body>
</html>
