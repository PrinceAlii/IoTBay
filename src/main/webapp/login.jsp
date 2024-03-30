<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Random" %>
<%@page import="uts.isd.model.*" %>
            <!DOCTYPE html>
            <html>
            <head>
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="css/register.css">
                <script type="text/javascript" src="js/index.js"></script>
                <title>Login</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
            </head>

            <body class="text-center">
            <%-- <%
                
                User user1 = (User) session.getAttribute("user");

                
                if (user1 != null) {
                    
                    out.println("User object exists in the session.");
                    
                    out.println("User Email: " + user1.getEmail());
                    out.println("User Name: " + user1.getName());
                    
                } else {
                    
                    out.println("User object does not exist in the session.");
                }
            %> --%>

            <form action="login.jsp" method="post">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" placeholder="email" required/>
                <br>
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" placeholder="password" required/>
                <br/>
                <input type="hidden" name="submitted" id="submitted" value="true" />
                <br>
                <button type="submit">Login</button>
                  <form action="index.jsp" method="post">
                <button type="submit">Cancel Login</button>
        </form>
            </form>

             <%
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String submitted = request.getParameter("submitted");

                if (submitted != null) {
                    User user = (User) session.getAttribute("user");

                    if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                        response.sendRedirect("main.jsp");
                    } else { %> 
                        <h1>Incorrect email or password!</h1>
                    <% }
                }
                     %>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
            </body>

            </html>