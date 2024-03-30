<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Random" %>
<%@page import="uts.isd.model.*" %>
            <!DOCTYPE html>
            <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="css/layout.css">
                <script type="text/javascript" src="js/index.js"></script>
                <title>Login</title>
            </head>

            <body>
            <%
                
                User user1 = (User) session.getAttribute("user");

                
                if (user1 != null) {
                    
                    out.println("User object exists in the session.");
                    
                    out.println("User Email: " + user1.getEmail());
                    out.println("User Name: " + user1.getName());
                    
                } else {
                    
                    out.println("User object does not exist in the session.");
                }
            %>
            <form action="login.jsp" method="post">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" placeholder="email" required/>
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" placeholder="password" required/>
                <br/>
                <input type="hidden" name="submitted" id="submitted" value="true" />
                <button type="submit">Login</button>
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

            </body>

            </html>