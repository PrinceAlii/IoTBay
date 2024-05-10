<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.*" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>

    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th,
        td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>

<body class="text-center">

    <% User user=(User) session.getAttribute("user"); %>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">IotBay</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                </ul>
                <ul class="navbar-nav ms-auto" style="padding-right: 30px;">
                    <li class="nav-item">
                        <a class="nav-link" href="main.jsp">Home</a>
                    </li>
                    <li class="nav-item dropdown" style="padding-right: 40px;">
                        <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                            Profile
                        </button>
                        <ul class="dropdown-menu dropdown-menu-dark">
                            <li><a class="dropdown-item" href="accountDetails.jsp">Account Details</a></li>
                            <li><a class="dropdown-item" href="paymentDetails">Payment Details</a></li>
                            <li><a class="dropdown-item" href="#">Access Logs</a></li>
                            <li><a class="dropdown-item active" href="OrderServlet">Order Details</a></li>
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
    <div style="text-align:center;">
        <br>
        <br>
        <h1>Order Details</h1>
        <br>
    </div>
    <div>
        <table cellpadding="5">
            <br>
            <h2>List of Orders</h2>
            <tr>
                <th>Order ID</th>
                <th>Total Amount</th>
                <th>Order Date</th>
                <th>Product Quantity</th>
                <th>User ID</th>
                <th>Product ID</th>
                <th>Actions</th>
            </tr>
            <% 
            List<Order> orderDetail = (List<Order>) request.getAttribute("orderDetail");
            if (orderDetail != null && !orderDetail.isEmpty()) {
                for (Order order : orderDetail) {
            %>
            <tr>
                <td><%= order.getOrderID() %></td>
                <td><%= order.getOrderAmount() %></td>
                <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderLogTimestamp()) %></td>
                <td><%= order.getProductQuantity() %></td>
                <td><%= order.getUserID() %></td>
                <td><%= order.getProductID() %></td>
                <td>
                    <a href="editOrder.jsp?orderID=<%= order.getOrderID() %>">Edit</a>
                    &nbsp;|&nbsp;
                    <a href="deleteOrder?orderID=<%= order.getOrderID() %>" onclick="return confirm('Are you sure you want to delete this order?');">Delete</a>
                </td>
            </tr>
            <% 
                }
            } else {
            %>
            <tr>
                <td colspan="7">No orders found.</td>
            </tr>
            <% 
            }
            %>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
