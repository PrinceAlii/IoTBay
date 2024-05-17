<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Staff</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">IotBay</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="main.jsp">Home</a>
                        </li>
                        <li class="nav-item dropdown" style="padding-right: 40px;">
                            <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                Profile
                            </button>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="accountDetails.jsp">Account Details</a></li>
                                <li><a class="dropdown-item" href="paymentDetails">Saved Payments</a></li>
                                <li><a class="dropdown-item" href="paymentHistory">Payment History</a></li>
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
            <h1>Update Staff Record</h1>
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

            <form action="UpdateStaffRecordServlet" method="post">
                <label for="userID">User ID:</label><br>
                <input type="text" name="userID" value="<%= request.getParameter("userID") != null ? request.getParameter("userID") : "" %>"><br>

                
                <label for="userName">Name:</label><br>
                <input type="text" id="userName" name="userName" value="<%= request.getParameter("userName") != null ? request.getParameter("userName") : "" %>" required><br>
                
                <label for="userEmail">Email:</label><br>
                <input type="email" id="userEmail" name="userEmail" value="<%= request.getParameter("userEmail") != null ? request.getParameter("userEmail") : "" %>" required><br>
                
                <label for="userContactNumber">Phone Number:</label><br>
                <input type="text" id="userContactNumber" name="userContactNumber" value="<%= request.getParameter("userContactNumber") != null ? request.getParameter("userContactNumber") : "" %>" required><br>
                
                <label for="userPassword">Password:</label><br>
                <input type="password" id="userPassword" name="userPassword" value="<%= request.getParameter("userPassword") != null ? request.getParameter("userPassword") : "" %>" required><br>

                <label for="userAccount">User Account:</label><br>
                <input type="text" id="userAccount" name="userAccount" value="<%= request.getParameter("userAccount") != null ? request.getParameter("userAccount") : "" %>" required><br>

                <label for="userType">User Type:</label><br>
                <input type="text" id="userType" name="userType" value="<%= request.getParameter("userType") != null ? request.getParameter("userType") : "" %>" required><br>

                <label for="userPosition">Position:</label><br>
                <input type="text" id="userPosition" name="userPosition" value="<%= request.getParameter("userPosition") != null ? request.getParameter("userPosition") : "" %>" required><br>

                <label for="userStatus">Status:</label><br>
                <input type="checkbox" id="userStatus" name="userStatus" <%= request.getParameter("userStatus") != null ? "checked" : "" %>><br>

                <button type="submit" class="btn btn-primary">Update Staff</button>
            </form>
        </div>
    </body>
</html>
