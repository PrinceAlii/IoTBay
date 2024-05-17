package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.AdminStaffDAO;

public class DeleteStaffRecordServlet extends HttpServlet {

    private AdminStaffDAO staffDAO;

    @Override
    public void init() throws ServletException {
        try {
            DBConnector dbConnector = new DBConnector();
            staffDAO = new AdminStaffDAO(dbConnector);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> errors = new ArrayList<>();

        try {
            int userID = Integer.parseInt(request.getParameter("userID"));

            // Check if userID contains only numbers
            if (!request.getParameter("userID").matches("\\d+")) {
                errors.add("User ID must contain only numbers.");
            } else {
                // Check if the user with the given userID exists
                if (!staffDAO.checkUserIDExists(userID)) {
                    errors.add("User with ID " + userID + " does not exist.");
                } else {
                    // Check if user account is "staff"
                    if (!staffDAO.checkUserAccountIsStaff(userID)) {
                        errors.add("User with ID " + userID + " is not a staff member.");
                    } else {
                        // Delete the staff record
                        boolean deleted = staffDAO.deleteStaff(userID);
                        if (deleted) {
                            request.setAttribute("success", "Staff Record with ID " + userID + " deleted successfully.");
                        } else {
                            errors.add("Failed to delete staff record with ID " + userID + ".");
                        }
                    }
                }
            }

        } catch (SQLException ex) {
            errors.add("Error occurred while deleting the staff record: " + ex.getMessage());
        }

        request.setAttribute("errors", errors);
        request.getRequestDispatcher("DeleteStaffRecord.jsp").forward(request, response);
    }
}
