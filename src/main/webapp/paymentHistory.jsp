<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.PaymentDetails" %>
<%@ page import="uts.isd.model.User" %>
<%@ page import="uts.isd.model.Order" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>
</head>

<body class="text-center">

    <% User user = (User) session.getAttribute("user");%>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="main.jsp">IotBay</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
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
                        <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Profile
                        </button>
                        <ul class="dropdown-menu dropdown-menu-dark">
                            <li><a class="dropdown-item" href="accountDetails.jsp">Account Details</a></li>
                            <li><a class="dropdown-item" href="paymentDetails">Saved Payments</a></li>  
                            <li><a class="dropdown-item active" href="paymentHistory">Payment History</a></li>  
                            <li><a class="dropdown-item" href="/accessLogServlet">Access Logs</a></li>              
                            <li><a class="dropdown-item" href="OrderServlet">Order Details</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav> 
    
    <div class="container d-flex h-100 align-items-center justify-content-center">
        <div class="text-center">
            <br>
            <br>
            <h1>Payment History</h1>
            <br>

        <form action="paymentHistory" method="post">
            <input type="text" name="searchPaymentID" placeholder="Enter Payment ID">
            <input type="date" name="searchDate" placeholder="Select Date">
            <button type="submit" class="btn btn-primary">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                </svg>
                Search
            </button>
        </form>
        <br>
        <%! 
            public String formatDate(java.util.Date date) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                return sdf.format(date);
            }
        %>
            <table class="table table-bordered">
                <thead>
                    <tr>
                    <th>Order ID</th>
                    <th>Payment ID</th>
                    <th>Order Amount</th>
                    <th>Order Date</th>

                    </tr>
                </thead>

                <tbody>
                    <% List<Order> orders = (List<Order>) request.getAttribute("orders");
                    if (orders != null && !orders.isEmpty()) {
                        for (Order order : orders) {
                    %>
                    <tr>
                    <td><%= order.getOrderID() %></td>
                    <td><%= order.getPaymentID() %></td>
                    <td><%= order.getOrderAmount() %></td>
                    <td><%= formatDate(order.getOrderLogTimestamp()) %></td>

                    </tr>
                    <%    }
                    } else { %>
                    <tr>
                    <td colspan="2">No orders found.</td>
                    </tr>
                    <% } %>
                </tbody>
                
            </table>

            
            <br>
            <br>
            <div class="text-center">
                <%-- <a href="addPayment.jsp" class="btn btn-success me-2">Add Payment Method</a>
                <a href="removePayment" class="btn btn-danger me-2"">Remove a Payment Method</a>
                <a href="updatePayment" class="btn btn-warning">Update a Payment Method</a> --%>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>

</html>
