<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<link rel="stylesheet" href="css/style.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>

   <body class="text-center">
            <%
            User user = (User) session.getAttribute("user");
            %>

            <%
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            %>

            <div class="container d-flex h-100 align-items-center justify-content-center">
                <div class="text-center">
                        <h1>Welcome, <%= user.getName() %>!</h1>
                    <br>
                    <a id="welcome" href="main.jsp" class="btn btn-success">Click here to continue</a>
                </div>
            </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>            
    </body>
</html>
