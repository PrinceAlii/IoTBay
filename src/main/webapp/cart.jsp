<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="uts.isd.model.OrderLineItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Your Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>

</head>
<body>
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
                    <li class="nav-item">
                        <a class="nav-link" href="cart.jsp">Cart</a>
                    </li>
                    <li class="nav-item dropdown" style="padding-right: 40px;">
                        <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                            Profile
                        </button>
                        <ul class="dropdown-menu dropdown-menu-dark">
                            <li><a class="dropdown-item" href="accountDetails.jsp">Account Details</a></li>
                            <li><a class="dropdown-item" href="paymentDetails">Payment Details</a></li>
                            <li><a class="dropdown-item" href="#">Access Logs</a></li>
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
    <div class="container mt-4">
        <h2>Shopping Cart</h2>
        <% 
            List<OrderLineItem> cart = (List<OrderLineItem>) session.getAttribute("cart");
            if (cart == null || cart.isEmpty()) {
        %>
            <p>Your cart is empty.</p>
        <% } else { %>
            <table class="table">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (OrderLineItem item : cart) { %>
                    <tr>
                        <td><%= item.getProductID() %></td>
                        <td>
                            <form action="CartServlet" method="post">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="productId" value="<%= item.getProductID() %>">
                                <input style="width: 100px; margin-right: 10px; height: 38px; padding: 5px 10px" type="number" name="quantity" value="<%= item.getOrderQuantity() %>" min="1">
                                <button type="submit" class="btn btn-info">Update</button>
                            </form>
                        </td>
                        <td>
                            <a href="CartServlet?action=remove&productId=<%= item.getProductID() %>" class="btn btn-danger">Remove</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <a href="CartServlet?action=submit" class="btn btn-success">Submit Order</a>
            <a href="CartServlet?action=cancel" class="btn btn-warning">Cancel Order</a>
        <% } %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>


