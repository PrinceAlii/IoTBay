<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Random" %>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>

    <body class="text-center">
        <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">IotBay</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
                </div>
            </div>
        </nav>


        <%
            String incorrectLogin = (String) session.getAttribute("incorrectLogin");
        %>

        <h1>Login</h1>
        <br>
        <label style="color: red;"><%= (incorrectLogin != null ? incorrectLogin : "") %></label>
        <br>
        <br>
        <div class="container-sm d-flex justify-content-center" >

            <form action="LoginServlet" method="post" style="width: 20%;">
            <div class="mb-3">
                <div class="row justify-content-start">
                    <div class="col-3">
                        <label class="form-label" style="font-weight: bold;" for="email">Email:</label>
                        </div>
                    </div>
                <input class="form-control" type="email" name="email" id="email" placeholder="Email") required/>
            </div>
            <br>
            <div class="mb-3">
                <div class="row justify-content-start">
                    <div class="col-3">
                        <label class="form-label" style="font-weight: bold;" for="password">Password:</label>
                    </div>
            </div>
                <input class="form-control" type="password" name="password" id="password" placeholder="password" required/>
            </div>
            <br/>
            <div class="mb-3">
                <input type="hidden" name="submitted" id="submitted" value="true" />
            </div>
                <button class="btn btn-primary" href="welcome.jsp" type="submit">Login</button>
                <a class="btn btn-outline-secondary"  id="cancel" href="index.jsp">Cancel Login</a>
            </form>
        </div>
    </body> 
</html>



