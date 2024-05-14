package uts.isd.model.controller;
import java.sql.Connection;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddStaffRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");
        String password = request.getParameter("password");
        String userAccount = request.getParameter("userAccount");
        String userType = request.getParameter("userType");

        
        System.out.println("New staff record created:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("PhoneNo: " + phoneNo);
        System.out.println("Password: " + password);
        System.out.println("User Account: " + userAccount);
        System.out.println("User Type: " + userType);

    
        RequestDispatcher dispatcher = request.getRequestDispatcher("CreateStaffRecord.jsp");
        dispatcher.forward(request, response);
    }
}
