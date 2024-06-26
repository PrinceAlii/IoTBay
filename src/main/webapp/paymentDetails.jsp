<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.PaymentDetails" %>
<%@page import="java.util.List" %>
<%@ page import="uts.isd.model.User" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Saved Payment Details</title>
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
                            <li><a class="dropdown-item active" href="paymentDetails">Saved Payments</a></li> 
                            <li><a class="dropdown-item" href="paymentHistory">Payment History</a></li>               
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

    <%
        String paymentAdded = request.getParameter("paymentAdded");
        if (paymentAdded != null && paymentAdded.equals("true")) {
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        Payment method has been saved successfully.
    </div>
    <%
        }
    %>

    <%
        String updateDefault = request.getParameter("updateDefault");
        if (updateDefault != null && updateDefault.equals("true")) {
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        Your selected payment has now been made your default for all new purchses..
    </div>
    <%
        }
    %>


    <% 
    String action = request.getParameter("action");
    if (action != null && action.equals("removed")) {

    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        Saved payment method removed successfully.
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>

    <% } %>

    <%
        String successParam = request.getParameter("success");
        if (successParam != null && successParam.equals("true")) {
        %>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            Payment details updated successfully!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    <% } %>

    
    <div class="container d-flex h-100 align-items-center justify-content-center">
        <div class="text-center">
            <br>
            <br>
            <h1>Saved Payment Details</h1>
            <br>

       <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">Payment ID</th>
                    <th scope="col">Card Issuer</th>
                    <th scope="col">Last 4 digits of card number</th>
                    <th scope="col">Name on card</th>
                    <th scope="col">Status</th> 
                </tr>
            </thead>
            <tbody>
                <% 
                List<PaymentDetails> paymentMethods = (List<PaymentDetails>) request.getAttribute("paymentMethods");
                if (paymentMethods != null && !paymentMethods.isEmpty()) {
                    for (PaymentDetails payment : paymentMethods) {
                %>
                <tr>
                    <td><%= payment.getPaymentID() %></td>
                    <td><%= payment.getPaymentMethod() %></td>
                    <td><%= payment.getPaymentCardDetails() %></td>
                    <td><%= user.getName() %></td>
                    <td>
                        <% 
                        if (payment.isDefaultPaymentForUser(payment.getPaymentID(), payment.getUserID())) { %>
                            <span class="badge bg-success">Default</span>
                        <% } %>
                    </td>
                </tr>
                <% } } else { %> 
                <tr>
                    <td colspan="5">No payment details found.</td>
                </tr>
                <% } %> 
            </tbody>
        </table>

            
            <br>
            <br>
            <div class="text-center">
                <a href="addPayment.jsp" class="btn btn-success me-2">Add Payment Method</a>
                <a href="removePayment" class="btn btn-danger me-2"">Remove a Payment Method</a>
                <a href="updatePayment" class="btn btn-warning">Update a Payment Method</a>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>

</html>
