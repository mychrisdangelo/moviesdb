<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>moviesDB</title>
</head>
<body>

<H1>Movies Database</H1>

<h3>By Chris D'Angelo (cd2665@columbia.edu)
   and Xin Du (xd2137@columbia.edu)</h3>
<%
if (request.getAttribute("loginError")!= null){
String errorMessage = request.getAttribute("loginError").toString();
out.print(errorMessage);
}
else {
	out.print("welcome");
}
%>
<br>
Please sign in
<form name='input' action='profile' method='get'>
Email: <input type='email' name='loggedinemail'>
Password: <input type='password' name='pwd'>
<input type='submit' value='Login'>
</form>
Or Please register
<form name='input' action='profile' method='get'>
Email: <input type='email' name='newemail'>
Password: <input type='password' name='pwd2'>
<br>
FirstName: <input type='text' name='firstName'>
LastName: <input type='text' name='lastName'>
<input type='submit' value='Sign-up'>
</form>




</body>
</html>




