package uts.isd.model.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteStaffRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve staff ID from the request
        String staffId = request.getParameter("staffId");

        // Delete the staff record (in this example, just printing the information)
        System.out.println("Staff record deleted:");
        System.out.println("Staff ID: " + staffId);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("deleteStaffRecord.jsp");
        dispatcher.forward(request, response);
    }
}
