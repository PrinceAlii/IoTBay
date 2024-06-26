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

        <%
            User user = (User)session.getAttribute("user");
            if(user != null){
            response.sendRedirect("main.jsp");
            }
        %>
        <%
            //error checking
            String emailUsed = (String) session.getAttribute("emailUsed");
            String inputtedNameErr = (String) session.getAttribute("inputtedNameErr");
            String inputtedPassErr = (String) session.getAttribute("inputtedPassErr");
            String inputtedPhoneErr = (String) session.getAttribute("inputtedPhoneErr");
        %>

        <br>
        <h1>Account registration</h1>
        <br>
        <label style="color: red;"><%= (emailUsed != null ? emailUsed : "") %></label>
        <br>
        <label style="color: red;"><%= (inputtedNameErr != null ? inputtedNameErr : "") %></label>
         <br>
        <label style="color: red;"><%= (inputtedPassErr != null ? inputtedPassErr : "") %></label>
         <br>
        <label style="color: red;"><%= (inputtedPhoneErr != null ? inputtedPhoneErr : "") %></label>
        <br>
        <br>
        <div class="container-sm d-flex justify-content-center">
            <form method="POST" action="RegisterServlet" style="width: 30%;">
                <div class="mb-3">
                    <div class="row justify-content-start">
                        <div class="col-2">
                            <label for="email" style="font-weight: bold;" class="form-label">Email:</label>
                        </div>
                    </div>
                    <input class="form-control" type="email" name="email" id="email" placeholder="e.g. johnsmith@gmail.com" required/>
                </div>
                <div class="mb-3">
                    <div class="row justify-content-start">
                        <div class="col-2">
                            <label for="name" style="font-weight: bold;" class="form-label">Name:</label>
                        </div>
                    </div>
                    <input class="form-control" name="name" id="name" placeholder="e.g. John Smith"  required/>
                </div>
                <div class="mb-3">
                    <div class="row justify-content-start">
                        <div class="col-2">
                            <label for="password" style="font-weight: bold;" class="form-label">Password:</label>
                        </div>
                    </div>
                    <input class="form-control" type="password" name="password" id="password" required/>
                </div>
                <div class="mb-3">
                    <div class="row justify-content-start">
                        <div class="col-2">
                            <label for="phone" style="font-weight: bold;" class="form-label">Phone:</label>
                        </div>
                    </div>
                    <input class="form-control" type="tel" name="phone" id="phone" placeholder="e.g. 0423746893"  required/>
                </div>
                <br/>
                <input type="hidden" name="submitted" id="submitted" value="true" />
                <button class="btn btn-primary" type="submit">Register Account</button>
                <a class="btn btn-outline-secondary" id="cancel" href="index.jsp">Cancel Registration</a>
            </form>
        </div>
    </body>
</html>