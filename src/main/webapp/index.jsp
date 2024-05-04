<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Home Page</title>
    </head>
    <body class="text-center">
        <% User user=(User) session.getAttribute("user"); %>

        <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">IotBay</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
                    <ul class="navbar-nav ms-auto">
                        <% if (user != null) { %>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Welcome, <%= user.getName() %>!</a>
                            </li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <br>
            <h1>Home Page</h1>
            <br>

            <% if (user == null) { %>
                <h2>You are not logged in</h2>
                <h3>Please select one of the below options to continue</h3>
                <br>
                <form action="login.jsp" method="post">
                    <button class="btn btn-primary" type="submit">Login to your account</button>
                </form>
                <br>
                <h3>or</h3>
                <br>
                <form action="register.jsp" method="post">
                    <button class="btn btn-primary" type="submit">Register an Account</button>
                </form>
                <br>
                <h3>or</h3>
                <br>
                <form action="main.jsp" method="post">
                    <button class="btn btn-secondary" type="submit">Continue as a guest</button>
                </form>
            <% } else { %>
                <div>
                    <h2>Welcome, <%= user.getName() %></h2>
                    <br>
                    <form action="main.jsp" method="post">
                        <button class="btn btn-outline-primary" type="submit">Browse Products</button>
                    </form>
                    <br>
                    <form action="logout.jsp" method="post">
                        <button class="btn btn-outline-danger" type="submit">Logout</button>
                    </form>
                </div>
            <% } %>
        </div>
        <jsp:include page="ConnServlet" flush ="true" />

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>