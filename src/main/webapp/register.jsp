<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
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

            <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="index.jsp">IotBay</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        </ul>

                    </div>
                </div>
            </nav>

    <br>
    <h1>Account registration</h1>
    <br>
    <br>
    <div class="container-sm d-flex justify-content-center" >
        <form style="width: 30%;">
            <div class="mb-3">
            <div class="row justify-content-start">
                <div class="col-2">
                <label for="email" style="font-weight: bold;" class="form-label">Email:</label>
            </div>
            </div>
                <input class="form-control" ype="email" name="email" id="email" placeholder="email" required/>
            </div>
            <div class="mb-3">
            <div class="row justify-content-start">
                <div class="col-2">
                <label for="name" style="font-weight: bold;" class="form-label">Name:</label>
            </div>
            </div>
                <input class="form-control" name="name" id="name" placeholder="name" required/>
            </div>
            <div class="mb-3">
            <div class="row justify-content-start">
                <div class="col-2">
                <label for="password" style="font-weight: bold;" class="form-label">Password:</label>
            </div>
            </div>
                <input class="form-control" type="password" name="password" id="password" placeholder="password" required/>
            </div>
            <div class="mb-3">
            <div class="row justify-content-start">
                <div class="col-2">
                <label for="phone" style="font-weight: bold;" class="form-label">Phone:</label>
            </div>
            </div>
                <input class="form-control" type="phone" class="form-label" name="phone" id="phone" placeholder="phone" required/>
            </div>
                <br/>
                <input type="hidden" name="submitted" id="submitted" value="true" />
                <button class="btn btn-primary" type="submit">Register Account</button>
                <a class="btn btn-outline-secondary"  id="cancel" href="index.jsp">Cancel Registration</a>
        </form>
    </div>

        <% } %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>        
    </body>
</html>
