<%@ page contentType="text/html;charset=UTF-8" session="true" errorPage="error.jsp" %>
<jsp:useBean class="Beans.IndexBean" id="indexBean" scope="session" />
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!----
written by Vitor Mouzinho June 10th 2016
--->
<html>
    <head>
        <title>Party Time!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">


    <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="container-fluid ">
            
<form class="form-inline well well-large headerNav " action="LoginServlet" method="POST">
    
    <div class="right form-group">PartyApp</div>
    <div class="spacet form-group"></div>
    
  <div class="form-group">
      
    
      <input type="email" class="form-control" name="loginEmail" placeholder="Email" value="<%= indexBean.getLoginEmail() %>">
  </div>
    <div class="space form-group"></div>
  <div class="form-group t" >
    
    <input type="password" class="form-control" name="loginPassword" placeholder="Password" >
  </div>
      
    
  <div class="form-group">
  <div class="checkbox">
    <label >
        <input type="checkbox" id="remember"> Remember me
    </label>
  </div>
  <input type="submit" class="btn btn-primary" value="Login"/>
  <%= indexBean.getLoginMessage() %>
</form>
          
        </div>
        
        
        <div class="container">
            <h1 class="partyHeader">Welcome To PartyApp</h1>
            <div class="party well">
        
            <img src="url/../images/party.png" alt="chejlxasjkck" style="width:80px; height:80px;">
          
            <p>
                
                 Party while making money
            </p>
            
         <img src="url/../images/chat.png" alt="chejlxasjkck">
         
         <p>
            
                 Chat with Party Goer's
            </p>
         
             <img src="url/../images/friends.jpg" alt="chejlxasjkck"> 
           <p>
              Make new Friends
            </p>
        </div>
            <div class="ccheck">
        <form class="well signUp" action="RegistrationServlet" method="POST">
  <fieldset class="form-group">
      <h1 class="signUpH">Sign Up</h1>
      <p class="signUpH"><%= indexBean.getRegMessage() %></p>
      <input type="text" class="form-control" name="regEmail" placeholder="Email Address" value="<%= indexBean.getRegEmail() %>">
  </fieldset>
  <fieldset class="form-group">
    <input type="text" class="form-control" name="regFirstName" placeholder="First Name" value="<%= indexBean.getRegFirstName() %>">
  </fieldset>
            <fieldset class="form-group">
    <input type="text" class="form-control" name="regLastName" placeholder="Last Name" value="<%= indexBean.getRegLastName() %>">
  </fieldset>
            <fieldset class="form-group">
    <input type="password" class="form-control" name="regPassword" placeholder="Password">
    
    
  </fieldset>
            <fieldset class="form-group">
    <input type="password" class="form-control" name="regConfirmPassword" placeholder="Comfirm Password">
  </fieldset>
            <fieldset class="form-group">
                <h2 style="color:white;">Birthday</h2>
            <select id="DOBMonth" name="DOBMonth">
	<option> - Month - </option>
	<option value="0">January</option>
	<option value="1">February</option>
	<option value="2">March</option>
	<option value="3">April</option>
	<option value="4">May</option>
	<option value="5">June</option>
	<option value="6">July</option>
	<option value="7">August</option>
	<option value="8">September</option>
	<option value="9">October</option>
	<option value="10">November</option>
	<option value="11">December</option>
</select>
              
            
            <select id="DOBDay" name="DOBDay">
	<option> - Day - </option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	<option value="13">13</option>
	<option value="14">14</option>
	<option value="15">15</option>
	<option value="16">16</option>
	<option value="17">17</option>
	<option value="18">18</option>
	<option value="19">19</option>
	<option value="20">20</option>
	<option value="21">21</option>
	<option value="22">22</option>
	<option value="23">23</option>
	<option value="24">24</option>
	<option value="25">25</option>
	<option value="26">26</option>
	<option value="27">27</option>
	<option value="28">28</option>
	<option value="29">29</option>
	<option value="30">30</option>
	<option value="31">31</option>
</select>
          
            
               
            <select id="DOBYear" name="DOBYear">
	<option> - Year - </option>
        <option value="2007">2007</option>
	<option value="2006">2006</option>
	<option value="2005">2005</option>
	<option value="2004">2004</option>
	<option value="2003">2003</option>
	<option value="2002">2002</option>
	<option value="2001">2001</option>
	<option value="2000">2000</option>
	<option value="1999">1999</option>
	<option value="1998">1998</option>
	<option value="1997">1997</option>
	<option value="1996">1996</option>
	<option value="1995">1995</option>
	<option value="1994">1994</option>
	<option value="1993">1993</option>
	<option value="1992">1992</option>
	<option value="1991">1991</option>
	<option value="1990">1990</option>
	<option value="1989">1989</option>
	<option value="1988">1988</option>
	<option value="1987">1987</option>
	<option value="1986">1986</option>
	<option value="1985">1985</option>
	<option value="1984">1984</option>
	<option value="1983">1983</option>
	<option value="1982">1982</option>
	<option value="1981">1981</option>
	<option value="1980">1980</option>
	<option value="1979">1979</option>
	<option value="1978">1978</option>
	<option value="1977">1977</option>
	<option value="1976">1976</option>
	<option value="1975">1975</option>
	<option value="1974">1974</option>
	<option value="1973">1973</option>
	<option value="1972">1972</option>
	<option value="1971">1971</option>
	<option value="1970">1970</option>
	<option value="1969">1969</option>
	<option value="1968">1968</option>
	<option value="1967">1967</option>
	<option value="1966">1966</option>
	<option value="1965">1965</option>
	<option value="1964">1964</option>
	<option value="1963">1963</option>
	<option value="1962">1962</option>
	<option value="1961">1961</option>
	<option value="1960">1960</option>
	<option value="1959">1959</option>
	<option value="1958">1958</option>
	<option value="1957">1957</option>
	<option value="1956">1956</option>
	<option value="1955">1955</option>
	<option value="1954">1954</option>
	<option value="1953">1953</option>
	<option value="1952">1952</option>
	<option value="1951">1951</option>
	<option value="1950">1950</option>
	<option value="1949">1949</option>
	<option value="1948">1948</option>
	<option value="1947">1947</option>
        
        
        <option value="1946">1946</option>
	<option value="1945">1945</option>
	<option value="1944">1944</option>
	<option value="1943">1943</option>
	<option value="1942">1942</option>
	<option value="1941">1941</option>
	<option value="1940">1940</option>
	<option value="1939">1939</option>
	<option value="1938">1938</option>
        
        <option value="1937">1937</option>
	<option value="1936">1936</option>
	<option value="1935">1935</option>
	<option value="1934">1934</option>
	<option value="1933">1933</option>
	<option value="1932">1932</option>
	<option value="1931">1931</option>
	<option value="1930">1930</option>
	<option value="1929">1929</option>
        
	
        <option value="1928">1928</option>
	<option value="1927">1927</option>
	<option value="1926">1926</option>
	<option value="1925">1925</option>
	<option value="1924">1924</option>
	<option value="1923">1923</option>
	<option value="1922">1922</option>
	<option value="1921">1921</option>
	<option value="1920">1920</option>
</select>
                </fieldset>
            <input type="submit" class="btn btn-primary" value="Sign Up" />
            <p style="margin-top:4%; color:white;"><small>By clicking Sign Up, you agree to our Terms and that you have read our Data Policy, including our Cookie Use.</small></p>
</form>
        </div>
        </div>
        
           <!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </body>
</html>
