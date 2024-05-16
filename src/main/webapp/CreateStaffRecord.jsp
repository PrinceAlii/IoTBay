<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="uts.isd.model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <title>New Staff Record</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 20px;
            }
            .container {
                max-width: 600px;
                margin: 0 auto;
                background-color: #fff;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
                color: #333;
                font-size: 28px;
                margin-bottom: 20px;
            }
            label {
                font-weight: bold;
                font-size: 18px;
            }
            input[type="text"],
            input[type="email"],
            textarea {
                width: 100%;
                padding: 12px;
                margin-bottom: 20px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 6px;
                font-size: 16px;
            }
            input[type="submit"] {
                background-color: #3498db;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 6px;
                cursor: pointer;
                font-size: 18px;
                display: block;
                width: 100%;
            }
            input[type="submit"]:hover {
                background-color: #2980b9;
            }
            .delete-btn {
                background-color: #e74c3c;
            }
            .delete-btn:hover {
                background-color: #c0392b;
            }
        </style>
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
                        <li class="nav-item">
                            <a class="nav-link" href="ViewStaffServlet">View Staff</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <h1>Add Staff Record</h1>
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

            <form action="AddStaffRecordServlet" method="post">
                <label for="userName">Name:</label><br>
                <input type="text" id="userName" name="userName" required><br>
                
                <label for="userEmail">Email:</label><br>
                <input type="email" id="userEmail" name="userEmail" required><br>
                
                <label for="userContactNumber">Phone Number:</label><br>
                <input type="text" id="userContactNumber" name="userContactNumber" required><br>
                
                <label for="userPassword">Password:</label><br>
                <input type="password" id="userPassword" name="userPassword" required><br>

                <label for="userAccount">User Account:</label><br>
                <input type="text" id="userAccount" name="userAccount" required><br>

                <label for="userType">User Type:</label><br>
                <input type="text" id="userType" name="userType" required><br>

                <label for="userPosition">Position:</label><br>
                <input type="text" id="userPosition" name="userPosition" required><br>

                <button type="submit" class="btn btn-primary">Create Staff</button>
            </form>
        </div>
    </body>
</html>
