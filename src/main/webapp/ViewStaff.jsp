<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Staff</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
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
            <h1>View Staff</h1>
            <form action="ViewStaffServlet" method="get">
                <div class="mb-3">
                    <label for="searchName" class="form-label">Search by Name:</label>
                    <input type="text" class="form-control" id="searchName" name="searchName">
                </div>
                <div class="mb-3">
                    <label for="searchUserPosition" class="form-label">Search by User Position:</label>
                    <select class="form-select" id="searchUserPosition" name="searchUserPosition">
                        <option value="">Select User Position</option>
                        <option value="CEO">CEO</option>
                        <option value="Manager">Manager</option>
                        <option value="Salesperson">Salesperson</option>
                        <option value="Administrator">Administrator</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>

            <!-- Display staff data in table format -->
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">User ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Contact Number</th>
                        <th scope="col">Position</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<User> staffList = (List<User>)request.getAttribute("staffList");
                        if(staffList != null && !staffList.isEmpty()) {
                            for(User staff : staffList) { %>
                                <tr>
                                    <td><%= staff.getUserID() %></td>
                                    <td><%= staff.getName() %></td>
                                    <td><%= staff.getEmail() %></td>
                                    <td><%= staff.getPhone() %></td>
                                    <td><%= staff.getUserPosition() %></td>
                                </tr>
                            <% }
                        } else { %>
                            <tr>
                                <td colspan="5">No staff found.</td>
                            </tr>
                        <% } %>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
