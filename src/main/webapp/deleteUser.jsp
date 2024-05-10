<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="uts.isd.model.*" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Delete Account</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>
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
                                <li class="nav-iten">
                                    <a class="btn" class ="nav-link" href="main.jsp">Home</a>
                                </li>
                                <li class="nav-iten">
                                    <a class="btn btn-outline-danger" class ="nav-link" href="logout.jsp">Logout</a>
                                </li>
                            </ul>
                        </div>
                    </div>
            </nav>
            <%
                String email = request.getParameter("email");
            %>
            <br>
            <br>
            <br>
            <br>
            <br>

            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="card p-4">
                            <h2 class="text-center">Please confirm</h2>
                            <p class="text-center">Are you sure you want to delete this user?</p>

                            <form method="POST" action="DeleteServlet?email=<%=user.getEmail()%>" class="d-flex justify-content-center">
                                <button type="submit" class="btn btn-danger mx-2">Delete</button>
                                <a class="btn btn-outline-secondary" href="accountDetails.jsp">Cancel</a>  
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        </body>

        </html>