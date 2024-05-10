<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.PaymentDetails" %>
<%@page import="java.util.List" %>
<%@ page import="uts.isd.model.User" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Payment</title>
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
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <h2 class="mt-5 mb-4">Add New Payment Method</h2>
                    <h5 class="mt-5 mb-4">Card Issuer</h5>
                    <form>

                        <div class="mb-3">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="paymentMethod" id="mastercard" value="MasterCard">
                                <label class="form-check-label" for="mastercard">MasterCard</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="paymentMethod" id="visa" value="Visa">
                                <label class="form-check-label" for="visa">Visa</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="paymentMethod" id="americanexpress" value="AmericanExpress">
                                <label class="form-check-label" for="americanexpress">American Express</label>
                            </div>
                        </div>

                        <br>

                        <div class="mb-3 form-group" style="width: 100%;">
                            <label for="cardNumber" class="form-label">Card Number</label>
                            <input type="text" class="form-control" id="cardNumber" placeholder="Enter card number">
                        </div>


                        <div class="row">
                            <div class="col-md-6 mb-3 form-group" style="width: 100%;">
                                <label for="expiryDate" class="form-label">Expiry Date</label>
                                <input type="text" class="form-control" id="expiryDate" placeholder="MM/YYYY">
                            </div>


                            <div class="col-md-6 mb-3 form-group" style="width: 100%;">
                                <label for="cvv" class="form-label">CVV</label>
                                <input type="text" class="form-control" id="cvv" placeholder="CVV">
                            </div>
                        </div>


                        <button type="submit" class="btn btn-primary me-2">Submit</button>
                        <a href="main.jsp" class="btn btn-danger">Cancel</a>
                    </form>
                </div>
            </div>
        </div>





    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>
