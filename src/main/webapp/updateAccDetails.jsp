<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="uts.isd.model.*" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Main Page</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.1/js/bootstrap.min.js"></script>
        </head>

        <body class="text-center">
        
            <% User user=(User) session.getAttribute("user"); %>
            <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="index.jsp">IotBay</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
                            
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-iten">
                                    <a class="btn" class ="nav-link" href="main.jsp">Home</a>
                                </li>
                                <li class="nav-iten">
                                    <a class="btn btn-outline-danger" class ="nav-link" href="logout.jsp">Logout</a>
                                </li>
                            </ul>
                        </div>
                    </div>
            </nav>


            <%
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String phone = request.getParameter("phone");  
            %>

            <%
            //error checking
            String emailInputtedErr = (String) session.getAttribute("emailInputtedErr");
            String inputtedNameErr = (String) session.getAttribute("inputtedNameErr");
            String inputtedPassErr = (String) session.getAttribute("inputtedPassErr");
            String inputtedPhoneErr = (String) session.getAttribute("inputtedPhoneErr");
            %>

            <%-- Update Details form --%>
            <br>
            <h1>Account registration</h1>
            <br>
            <label style="color: red;"><%= (emailInputtedErr != null ? emailInputtedErr : "") %></label>
            <br>
            <label style="color: red;"><%= (inputtedNameErr != null ? inputtedNameErr : "") %></label>
            <br>
            <label style="color: red;"><%= (inputtedPassErr != null ? inputtedPassErr : "") %></label>
            <br>
            <label style="color: red;"><%= (inputtedPhoneErr != null ? inputtedPhoneErr : "") %></label>
            <br>
            <br>
            <div class="container-sm d-flex justify-content-center">
                <form method="POST" action="updateAccDetailsServlet" style="width: 30%;">
                    <div class="mb-3">
                        <div class="row justify-content-start">
                            <div class="col-2">
                                <label for="email" style="font-weight: bold;" class="form-label">Email:</label>
                            </div>
                        </div>
                        <input class="form-control" type="email" name="email" id="email" placeholder=<%= user.getEmail() %> required/>
                    </div>
                    <div class="mb-3">
                        <div class="row justify-content-start">
                            <div class="col-2">
                                <label for="name" style="font-weight: bold;" class="form-label">Name:</label>
                            </div>
                        </div>
                        <input class="form-control" name="name" id="name" placeholder=<%= user.getName() %>  required/>
                    </div>
                    <div class="mb-3">
                        <div class="row justify-content-start">
                            <div class="col-2">
                                <label for="password" style="font-weight: bold;" class="form-label">Password:</label>
                            </div>
                        </div>
                        <input class="form-control" type="password" name="password" id="password" required/>
                    </div>
                    <div class="mb-3">
                        <div class="row justify-content-start">
                            <div class="col-2">
                                <label for="phone" style="font-weight: bold;" class="form-label">Phone:</label>
                            </div>
                        </div>
                        <input class="form-control" type="tel" name="phone" id="phone" placeholder=<%= user.getPhone() %>  required/>
                    </div>
                    <br/>
                    <input type="hidden" name="submitted" id="submitted" value="true"/>
                    <button class="btn btn-primary" type="submit">Update</button>
                    <a class="btn btn-outline-secondary" id="cancel" href="main.jsp">Cancel</a>
                </form>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        </body>

        </html>