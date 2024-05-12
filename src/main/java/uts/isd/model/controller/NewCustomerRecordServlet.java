package uts.isd.model.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NewCustomerRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve customer information from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // Create a new customer record (in this example, just printing the information)
        System.out.println("New customer record created:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("createCustomerRecord.jsp");
        dispatcher.forward(request, response);
    }
}
