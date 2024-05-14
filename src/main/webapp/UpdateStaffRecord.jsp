<!DOCTYPE html>
<html>
<head>
    <title>Update Staff Record</title>
    
</head>
<body>
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
