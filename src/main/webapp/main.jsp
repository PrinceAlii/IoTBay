<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <h1>Hello, <%= user.getName() %> </h1>
        <h1>Welcome to your account! </h1>

        <form action="logout.jsp" method="post">
            <button type="submit">Logout</button>
        </form>

        <% if(user == null) { %>
            <h1>You have not registered, please register first!</h1>
        <% } %>    
            
    </body>
</html>
