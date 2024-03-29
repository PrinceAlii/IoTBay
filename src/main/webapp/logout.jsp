<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
           session.invalidate();
           
        %>

        <h1>You have successfully been logged out. </h1>
        <h2>You will automatically be redirected after 5 seconds</h2>

        <script>

          setTimeout(function() {
          window.location.href = "index.jsp";
          }, 5000);

        </script>

    </body>
</html>
