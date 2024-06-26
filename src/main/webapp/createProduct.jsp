<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>
    </head>

    <body class="text-center">
        <% User user=(User) session.getAttribute("user"); %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">IotBay</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
                    <ul class="navbar-nav ms-auto" style="padding-right: 30px;"> 
                        <li class="nav-item">
                            <a class="nav-link" href="main.jsp">Home</a>
                        </li>
                        <li class="nav-iteitem dropdown" style="padding-right: 40px;">
                            <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                Profile
                            </button>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item active" href="accountDetails.jsp">Account Details</a></li>
                                <li><a class="dropdown-item" href="paymentDetails">Payment Details</a></li>
                                <li><a class="dropdown-item" href="#">Access Logs</a></li>
                                <li><a class="dropdown-item" href="OrderServlet">Order Details</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <h1 class="mt-5 mb-3">Create New Product</h1>
            <% if (request.getAttribute("success") != null) { %>
            <div class="alert alert-success" role="alert">
                <%= request.getAttribute("success") %>
            </div>
            <% } else if (request.getAttribute("errors") != null) { %>
            <div class="alert alert-danger" role="alert">
                <ul>
                    <% for (String error : (List<String>) request.getAttribute("errors")) { %>
                    <li><%= error %></li>
                    <% } %>
                </ul>
            </div>
            <% } %>

            <br>

            <form action="CreateProductServlet" method="post">
                <div class="container d-flex h-100 align-items-center justify-content-center">
                    <div class="text-center">
                        <table class="table table-borderless">
                            <tbody>
                                <tr>
                                    <th><label for="productID" class="form-label me-2">Product ID:</label></th>
                                    <td><input type="text" id="productID" name="productID" class="form-control" required></td>
                                </tr>
                                <tr>
                                    <th><label for="productName" class="form-label me-2">Product Name:</label></th>
                                    <td><input type="text" id="productName" name="productName" class="form-control" required></td>
                                </tr>
                                <tr>
                                    <th><label for="productType" class="form-label me-2">Product Type:</label></th>
                                    <td><input type="text" id="productType" name="productType" class="form-control" required></td>
                                </tr>
                                <tr>
                                    <th><label for="productPrice" class="form-label me-2">Product Price:</label></th>
                                    <td><input type="text" id="productPrice" name="productPrice" class="form-control" required></td>
                                </tr>
                                <tr>
                                    <th><label for="productDescription" class="form-label me-2">Product Description:</label></th>
                                    <td><input type="text" id="productDescription" name="productDescription" class="form-control" required></td>
                                </tr>
                                <tr>
                                    <th><label for="stockLevel" class="form-label me-2">Stock Level:</label></th>
                                    <td><input type="text" id="stockLevel" name="stockLevel" class="form-control" required></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="mt-4"><button type="submit" class="btn btn-primary">Create Product</button></div>
                    </div>
                </div>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>