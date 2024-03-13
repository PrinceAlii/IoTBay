<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>

    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Login Page</title>
    </head>

    <body>
        <div id="navigation">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Login</a></li>

            </ul>
        </div>

        <h1 id="loginHeader" class="center" >Login</h1>
        <div id="loginForm">
            <form>
                <table class="center">
                    <tr>
                        <th>
                            <label>Username: </label>
                            <input type="text" id="username" name="username" required><br><br>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <label>Password: </label>
                            <input type="password" id="password" name="password" required><br><br>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <input type="submit" value="Login">
                        </th>
                    </tr>

                </table>

            </form>
        </div>
    </body>

    </html>