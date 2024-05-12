<!DOCTYPE html>
<html>
<head>
    <title>Update Customer Record</title>
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
    <div class="container">
        <h1>Update Customer Record</h1>
        <form action="UpdateCustomerRecord" method="post">
            <input type="hidden" name="customerId" value="<%= request.getParameter("customerId") %>">
            
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" value="<%= request.getParameter("name") %>" required><br>
            
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" value="<%= request.getParameter("email") %>" required><br>
            
            <label for="address">Address:</label><br>
            <textarea id="address" name="address" required><%= request.getParameter("address") %></textarea><br>
            
            <input type="submit" value="Update">
        </form>
        
        <form action="DeleteCustomerRecord.jsp">
            <input type="submit" class="delete-btn" value="Delete">
        </form>
    </div>
</body>
</html>
