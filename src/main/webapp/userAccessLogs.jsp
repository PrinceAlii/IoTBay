<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="uts.isd.model.*" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.util.Iterator"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Access Logs</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
        </head>

        <body class="text-center">

        
            <% User user=(User) session.getAttribute("user"); %>

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
                                    <li><a class="dropdown-item" href="paymentDetails">Saved Payments</a></li>
                                    <li><a class="dropdown-item" href="paymentHistory">Payment History</a></li>
                                    <li><a class="dropdown-item" href="accessLogServlet">Access Logs</a></li>
                                    <li><a class="dropdown-item" href="OrderServlet">Order Details</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
                                </ul>
                                </li>
                                 <li>
                                <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <%
            String noLog = (String) session.getAttribute("noLogsFound");
            %>
        <!-- Loop through logs using -->
        <br>
            <h1>Access Logs</h1>
            <a><%= user.getName() %></a>
            <label><% %></label>
        <br>
        <br>
            <label style="color: red;"><%= (noLog != null ? noLog : "") %></label>
        <br>
        <!-- Search Bar -->
            <div class="row" style="padding-left: 50px; padding-right: 50px;">
                <div class="col-11 d-flex search-bar-container">  
                    <form class="d-flex" action="accessLogServlet" method="get" onsubmit="return validateSearch()">
                        <input id="searchInput" class="form-control me-2 w-100" type="search" placeholder="YYYY-MM-DD" aria-label="Search" name="search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
                <br>
       <!-- Access Logs Table -->
        <div class="table-wrapper-scroll-y my-custom-scrollbar">
        <br>
            <table class="table table-bordered table-striped mb-0 log-table">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Action</th>

                    </tr>
                </thead>
                <tbody>
                <c:catch var="e">
                <c:if test="${logs != null}">
                    <c:forEach items="${logs}" var="accessLog">
                    <tr>
                        <td>${accessLog.getLogAccessDate()}</td>
                        <td>${accessLog.getLogAccessTime()}</td>
                        <td>${accessLog.getLogStatus()}</td>
                    </tr>
                    </c:forEach>
                </c:if>
                </c:catch>
                </tbody>
            </table>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        </body>

    </html>