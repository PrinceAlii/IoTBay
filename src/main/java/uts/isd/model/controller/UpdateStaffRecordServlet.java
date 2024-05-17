package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.User;
import uts.isd.model.dao.AdminStaffDAO;
import uts.isd.model.dao.DBConnector;

public class UpdateStaffRecordServlet extends HttpServlet {

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
            String userName = request.getParameter("userName");
            String userEmail = request.getParameter("userEmail");
            String userPassword = request.getParameter("userPassword");
            String userContactNumber = request.getParameter("userContactNumber");
            boolean userStatus = "on".equals(request.getParameter("userStatus"));
            String userType = request.getParameter("userType");
            String userAccount = request.getParameter("userAccount");
            String userPosition = request.getParameter("userPosition");

            if (errors.isEmpty()) {
                User updatedStaff = new User();
                updatedStaff.setUserID(userID);
                updatedStaff.setName(userName);
                updatedStaff.setEmail(userEmail);
                updatedStaff.setPassword(userPassword);
                updatedStaff.setPhone(userContactNumber);
                updatedStaff.setUserType(userType);
                updatedStaff.setUserAccount(userAccount);
                updatedStaff.setUserStatus(userStatus);
                updatedStaff.setUserPosition(userPosition);

                staffDAO.updateStaff(updatedStaff);
                request.setAttribute("success", "Staff Record Updated!");
            }

        } catch (SQLException ex) {
            errors.add("Error occurred while updating the staff record: " + ex.getMessage());
        }

        request.setAttribute("errors", errors);
        request.getRequestDispatcher("UpdateStaffRecord.jsp").forward(request, response);
    }
}
