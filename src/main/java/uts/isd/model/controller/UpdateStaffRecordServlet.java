package uts.isd.model.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateStaffRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String staffId = request.getParameter("staffId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        
        System.out.println("Staff record updated:");
        System.out.println("Staff ID: " + staffId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateStaffRecord.jsp");
        dispatcher.forward(request, response);
    }
}
