<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="uts.isd.model.*" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Main Page</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>
        </head>

        <body class="text-center">
        
            <% User user=(User) session.getAttribute("user"); %>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="main.jsp">IotBay</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        </ul>
                        <ul class="navbar-nav ms-auto" style="padding-right: 30px;">
                                <li class="nav-item">
                                    <a class="nav-link" href="main.jsp">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="cart.jsp">Cart</a>
                                </li>
                                <li class="nav-item dropdown" style="padding-right: 40px;">
                                    <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                        Profile
                                    </button>
                                <ul class="dropdown-menu dropdown-menu-dark">

                                    <li><a class="dropdown-item" href="accountDetails.jsp">Account Details</a></li>
                                    <li><a class="dropdown-item" href="paymentDetails">Saved Payments</a></li>
                                    <li><a class="dropdown-item" href="paymentHistory">Payment History</a></li>
                                    <li><a class="dropdown-item" href="accessLogServlet">Access Logs</a></li>
                                    <li><a class="dropdown-item" href="OrderServlet">Order Details</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
                                </ul>
                                </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <%
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String phone = request.getParameter("phone");  
            %>

            <div class="container d-flex h-100 align-items-center justify-content-center">
                <div class="text-center">
                <br>
                <br>
                    <h1>Registration Details</h1>
                    <br>
                    <table class="table table-borderless">
                        <tbody>
                            <tr>
                                <th scope="row" style="text-align: left;">Name:</th>
                                <td style="text-align: left;"><%= user.getName() != null ? user.getName() : name %></td>
                            </tr>
                            <tr>
                                <th scope="row" style="text-align: left;">Email:</th>
                                <td style="text-align: left;"><%= user.getEmail() != null ? user.getEmail() : email %></td>
                            </tr>
                            <tr>
                                <th scope="row" style="text-align: left;">Password:</th>
                                <td style="text-align: left;"><%= user.getPassword() != null ? user.getPassword() : password %></td>
                            </tr>
                            <tr>
                                <th scope="row" style="text-align: left;">Contact Number:</th>
                                <td style="text-align: left;"><%= user.getPhone() != null ? user.getPhone() : phone %></td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    <div>
                        <a id="updateRegistration" href="updateAccDetails.jsp" class="btn btn-success">Update</a>
                        <a id="deleteRegistration" href="deleteUser.jsp" class="btn btn-danger">Delete</a>
                    </div>
                </div>
            </div>


            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        </body>

        </html>