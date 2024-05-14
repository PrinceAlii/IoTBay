package uts.isd.model.controller;
import java.sql.Connection;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateStaffRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String staffId = request.getParameter("staffId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");
        String password = request.getParameter("password");
        String userAccount = request.getParameter("userAccount");
        String userType = request.getParameter("userType");
        boolean userStatus = Boolean.parseBoolean(request.getParameter("userStatus"));

        // Update the staff record (in this example, just printing the information)
        System.out.println("Staff record updated:");
        System.out.println("Staff ID: " + staffId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Password: " + password);
        System.out.println("User Account: " + userAccount);
        System.out.println("User Type: " + userType);
        System.out.println("User Status: " + userStatus);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateStaffRecord.jsp");
        dispatcher.forward(request, response);
    }
}
