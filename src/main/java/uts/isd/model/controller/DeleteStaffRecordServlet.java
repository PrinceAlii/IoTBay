package uts.isd.model.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteStaffRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String staffId = request.getParameter("staffId");

        
        boolean success = deleteStaffRecordFromDatabase(staffId);

        if (success) {
            
            System.out.println("Staff record deleted:");
            System.out.println("Staff ID: " + staffId);

            
            RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteStaffRecord.jsp");
            dispatcher.forward(request, response);
        } else {
            
            System.out.println("Failed to delete staff record.");
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp");
            dispatcher.forward(request, response);
        }
    }

    private boolean deleteStaffRecordFromDatabase(String staffId) {
        
        return true; 
    }
}
