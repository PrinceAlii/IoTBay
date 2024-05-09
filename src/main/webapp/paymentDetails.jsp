<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.PaymentDetails" %>
<%@page import="java.util.List" %>
<%@ page import="uts.isd.model.User" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Payment Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>
  </head>
  <body class="text-center">
    <% User user = (User) session.getAttribute("user");%> 
  
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
                        <li class="nav-item dropdown" style="padding-right: 40px;">
                            <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                Profile
                            </button>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="accountDetails.jsp">Account Details</a></li>
                                <li><a class="dropdown-item active" href="paymentDetails">Payment Details</a></li>
                                <li><a class="dropdown-item" href="#">Access Logs</a></li>
                                <li><hr class="dropdown-divider"></li>
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
            <h1>Saved Payment Details</h1>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scop="col">#</th>
                        <th scope="col">Card Issuer</th>
                        <th scope="col">Last 4 digits of card number</th>
                        <th scope="col">Name on card</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    List <PaymentDetails> paymentMethods = (List<PaymentDetails>) request.getAttribute("paymentMethods");

                    if (paymentMethods != null && !paymentMethods.isEmpty()) {
                        for (PaymentDetails payment : paymentMethods) {
                    %>
                    <tr>
                        <th scope="row"><%= payment.getPaymentID() %> </th>
                        <td><%= payment.getPaymentMethod() %> </td>
                        <td><%= payment.getPaymentCardDetails() %> </td>
                        <td><%= user.getName() %> </td>
                    </tr>
                    <% 
                        }
                    } else {
                    %> 
                    <tr>
                        <td colspan="4">No payment details found.</td>
                    </tr>
                    <% } %> 
                </tbody>
            </table>
            
            <br>
            <br>
            <div class="text-center">
                <a href="addPayment" class="btn btn-success me-2">Add Payment Method</a>
                <a href="main.jsp" class="btn btn-danger">Remove a Payment Method</a>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>
