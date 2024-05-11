<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>
        <script>
            function validateSearch() {
                var searchKeyword = document.getElementById("searchInput").value.trim();
                if (searchKeyword === "") {
                    alert("Please enter a search keyword.");
                    return false; // Prevent form submission
                }
                return true; // Allow form submission
            }
        </script>
        <script>
            function setFilter(filter) {
            document.getElementById('filterInput').value = filter;
            document.getElementById('searchForm').submit();
            }
        </script>
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
                    <% if (user != null) { %>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Welcome, <%= user.getName() %>!</a>
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
                        <% } else { %>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register.jsp">Register</a>
                        </li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="row">
            <div class="col-11 d-flex search-bar-container">
                <form id="searchForm" class="d-flex" action="ProductServlet" method="get" onsubmit="return validateSearch()">
                    <input id="searchInput" class="form-control me-2 w-100" type="search" placeholder="Search" aria-label="Search" name="search">
                    <input type="hidden" id="filterInput" name="filter" value="">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
            <div class="col-1 d-flex justify-content-end">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Filter
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#" onclick="setFilter('Bed')">Bed</a>
                        <a class="dropdown-item" href="#" onclick="setFilter('Chair')">Chair</a>
                        <a class="dropdown-item" href="#" onclick="setFilter('Couch')">Couch</a>
                        <a class="dropdown-item" href="#" onclick="setFilter('Lamp')">Lamp</a>
                        <a class="dropdown-item" href="#" onclick="setFilter('Table')">Table</a>
                    </div>
                </div>
            </div>
        </div>

        <br>
        <br>
        <br>

        <div class="container">
            <div class="row">
                <% List<Product> products = (List<Product>)request.getAttribute("products");
                    if(products != null && !products.isEmpty()) {
                        for(Product product : products) { %>
                <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
                    <div class="card h-100">
                        <div class="card-body">
                            <img src="<%= product.getImageUrl() %>" class="card-img-top" alt="<%= product.getProductName() %>">
                            <h5 class="card-title"><%= product.getProductName() %></h5>
                            <p class="card-text">Price: $<%= product.getProductPrice() %></p>
                        </div>
                    </div>
                </div>
                <% }
                    } else {
                        String searchKeyword = request.getParameter("search");
                        if(searchKeyword != null && !searchKeyword.isEmpty()) { %>
                <div class="col-lg-12">
                    <p>No products found</p>
                </div>
                <% }
                    } %>
            </div>
        </div>
        
        <br>
        <br>
        <br>

        <div class="footer">
            <div class="row">
                <div class="col">
                    <div class="btn-group dropup">
                        <button class="btn btn-secondary dropdown-toggle 
                                <% if (user == null || !user.getUserAccount().equals("Staff")) { %>
                                    disabled
                                <% } %>
                                " type="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Staff Options
                        </button>
                        <div class="dropdown-menu" aria-labelledby="staffDropdown">
                            <a class="dropdown-item" href="createProduct.jsp">Create Product</a>
                            <a class="dropdown-item" href="updateProduct.jsp">Update Product</a>
                            <a class="dropdown-item" href="deleteProduct.jsp">Delete Product</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="btn-group dropup">
                        <button class="btn btn-secondary dropdown-toggle 
                                <% if (user == null || !user.getUserAccount().equals("System Admin")) { %>
                                    disabled
                                <% } %>
                                " type="button" id="adminDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                            System Admin Options
                        </button>
                        <div class="dropdown-menu" aria-labelledby="adminDropdown">
                            <a class="dropdown-item" href="#">Create User</a>
                            <a class="dropdown-item" href="#">Update User</a>
                            <a class="dropdown-item" href="#">Delete User</a>
                            <a class="dropdown-item" href="#">Create Staff</a>
                            <a class="dropdown-item" href="#">Update Staff</a>
                            <a class="dropdown-item" href="#">Delete Staff</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>