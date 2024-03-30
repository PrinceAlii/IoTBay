<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body class="text-center">
        <%
            User user = (User) session.getAttribute("user");
        %>
        <h1>Hello, <%= user.getName() %> </h1>
        <h1>Welcome to your account! </h1>

        <form action="logout.jsp" method="post">
            <button type="submit">Logout</button>
        </form>
        <form action="index.jsp" method="post">
            <button type="submit">Return to the home page</button>
        </form>

        <% if(user == null) { %>
            <h1>You have not registered, please register first!</h1>
        <% } %>    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>                
    </body>
</html>
