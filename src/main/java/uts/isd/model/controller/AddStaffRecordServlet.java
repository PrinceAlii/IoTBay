package uts.isd.model.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddStaffRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        
        System.out.println("New staff record created:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);

    
        RequestDispatcher dispatcher = request.getRequestDispatcher("CreateStaffRecord.jsp");
        dispatcher.forward(request, response);
    }
}
