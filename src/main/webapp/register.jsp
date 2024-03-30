<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/register.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Register</title>
    </head>
    <body class="text-center">
        <%
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String submitted = request.getParameter("submitted");

            if (submitted != null){
                User user = new User(email, name, phone, password);

                session.setAttribute("user", user);

                response.sendRedirect("welcome.jsp");

            } else { %>

        <form>
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" placeholder="email" required/>
            <label for="name">Full Name:</label>
            <input name="name" id="name" placeholder="name" required/>
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" placeholder="password" required/>
            <label for="phone">Phone:</label>
            <input type="phone" name="phone" id="phone" placeholder="phone" required/>
            <br/>
            <input type="hidden" name="submitted" id="submitted" value="true" />
            <button type="submit">Register Account</button>
            <button><a id="cancel" href="/">Cancel Registration</a></button>
        </form>

        <% } %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>        
    </body>
</html>
