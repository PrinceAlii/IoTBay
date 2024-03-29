<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/register.css">
        <title>Register</title>
    </head>
    <body >
        <%
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String favCol = request.getParameter("favcol");
            String gender = request.getParameter("gender");
            String tos = request.getParameter("tos");
            String submitted = request.getParameter("submitted");

            if (submitted != null){
                User user = new User(email, name, phone, password, gender, favCol);
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

    </body>
</html>
