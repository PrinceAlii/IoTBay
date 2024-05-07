<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.*" %>
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
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        </ul>
                    
                    <ul class="navbar-nav ms-auto"> <% if (user != null) { %>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Welcome, <%= user.getName() %>!</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-danger" class ="nav-link" href="logout.jsp">Logout</a>
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
            <div class="col-11 d-flex search-bar-container">  <form class="d-flex" action="main.jsp" method="get">
                <input class="form-control me-2 w-100" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
            <div class="col-1 d-flex justify-content-end">  
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Filter
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">Table</a>
                        <a class="dropdown-item" href="#">Chair</a>
                        <a class="dropdown-item" href="#">Couch</a>
                    </div>
                </div>
            </div>
        </div>

        <br>
        <%-- <div class="search-results">
            <% if (searchResults != null && !searchResults.isEmpty()) { %>
                <ul class="list-group">
                <% for (Product product : searchResults) { %>
                    <li class="list-group-item">
                    <a href="productDetails.jsp?id=<%= product.getProductID() %>">
                        <%= product.getProductName() %> - $<%= product.getProductPrice() %>
                    </a>
                    </li>
                <% } %>
                </ul>
            <% } else { %>
                <p>No search results found</p>
            <% } %>
        </div> --%>

        <br>
        <br>

        <p>Products products products</p>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>                    
        <br>
        <br>

        <div class="card">
            <div class="footer">   <div class="row">
                <div class="col">
                    <div class="btn-group dropup">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Staff Options
                    </button>
                        <div class="dropdown-menu" aria-labelledby="staffDropdown">
                            <a class="dropdown-item" href="#">Create Product</a>
                            <a class="dropdown-item" href="#">Update Product</a>
                            <a class="dropdown-item" href="#">Delete Product</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="btn-group dropup">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="adminDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        System Admin
                    </button>
                        <div class="dropdown-menu" aria-labelledby="adminDropdown">
                            <a class="dropdown-item" href="#">Create User</a>
                            <a class="dropdown-item" href="#">Update User</a>
                            <a class="dropdown-item" href="#">Delete User</a>
                        </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>

    </html>