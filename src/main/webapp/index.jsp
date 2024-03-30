<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="java.util.Random" %>
        <%@page import="uts.isd.model.*" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="css/layout.css">
                <script type="text/javascript" src="js/index.js"></script>
                <title>Home Page</title>
            </head>

            <body>
                <h1>Home Page</h1>
                
                <% User user=(User) session.getAttribute("user"); 

                if (user==null) { %>

                    <h1>You are not logged in</h1>

                    <form action="login.jsp" method="post">
                        <button type="submit">Login to your account</button>
                    </form>
                    <br>
                    <form action="register.jsp" method="post">
                        <button type="submit">Register an Account</button>
                    </form>
                    <% } else { %>

                        <h1>You are logged in</h1>
                        <form action="main.jsp" method="post">
                            <button type="submit">My Account</button>
                        </form>
                        <br>
                        <form action="logout.jsp" method="post">
                            <button type="submit">Logout</button>
                        </form>
                        <% } %>

                         
            </body>

            </html>