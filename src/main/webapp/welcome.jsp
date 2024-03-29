<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<link rel="stylesheet" href="css/style.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <%
             User user = (User) session.getAttribute("user");
        %>

        <%
            String email = request.getParameter("email");
            String name = request.getParameter("name");
        %>

        <h1>Thank you for registering, <%= user.getName() %>!</h1>
        <a id="welcome" href="main.jsp">Click here to continue</a>
    </body>
</html>
