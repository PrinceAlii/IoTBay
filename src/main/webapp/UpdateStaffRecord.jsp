<!DOCTYPE html>
<html>
<head>
    <title>Update Staff Record</title>
    
</head>
<body>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Staff Record</title>
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
        input[type="text"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #e74c3c;
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
        <h1>Delete Staff Record</h1>
        <form action="DeleteStaffRecord" method="post">
            <label for="staffId">Staff ID:</label><br>
            <input type="text" id="staffId" name="staffId" required><br><br>
            
            <input type="submit" value="Delete">
        </form>
    </div>
</body>
</html>
    <div class="container">
        <h1>Update Staff Record</h1>
        <form action="UpdateStaffRecord" method="post">
            <input type="hidden" name="staffId" value="<%= request.getParameter("staffId") %>">
            
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" value="<%= request.getParameter("name") %>" required><br>
            
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" value="<%= request.getParameter("email") %>" required><br>
            
            <label for="phoneNo">Phone Number:</label><br>
            <input type="text" id="phoneNo" name="phoneNo" value="<%= request.getParameter("phoneNo") %>" required><br>
            
            <label for="userType">User Type:</label><br>
            <input type="text" id="userType" name="userType" value="<%= request.getParameter("userType") %>" required><br>
            
            <label for="userAccount">User Account:</label><br>
            <input type="text" id="userAccount" name="userAccount" value="<%= request.getParameter("userAccount") %>" required><br>
            
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" value="<%= request.getParameter("password") %>" required><br>
            
            <label for="userStatus">User Status:</label><br>
            <select id="userStatus" name="userStatus">
                <option value="1">Active</option>
                <option value="0">Deactive</option>
            </select><br>
            
            <input type="submit" value="Update">
        </form>
        
        <form action="DeleteStaffRecord.jsp">
            <input type="submit" class="delete-btn" value="Delete">
        </form>
    </div>
</body>
</html>
