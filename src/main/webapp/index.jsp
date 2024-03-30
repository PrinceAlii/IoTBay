<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="java.util.Random" %>
        <%@page import="uts.isd.model.*" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="css/style.css">
                <script type="text/javascript" src="js/index.js"></script>
                <title>Home Page</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
            </head>

            <body class="text-center">
                <div>
                <h1>Home Page</h1>
                
                <% User user=(User) session.getAttribute("user"); 

                if (user==null) { %>

                    <h2>You are not logged in</h1>

                    <form action="login.jsp" method="post">
                        <button type="submit">Login to your account</button>
                    </form>
                    <br>
                    <form action="register.jsp" method="post">
                        <button type="submit">Register an Account</button>
                    </form>
                    <% } else { %>

                        <h2>You are logged in</h1>
                        <form action="main.jsp" method="post">
                            <button type="submit">My Account</button>
                        </form>
                        <br>
                        <form action="logout.jsp" method="post">
                            <button type="submit">Logout</button>
                        </form>
                        <% } %>
                </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>        
            </body>

            </html>