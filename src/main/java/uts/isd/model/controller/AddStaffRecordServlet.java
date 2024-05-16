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

public class AddStaffRecordServlet extends HttpServlet {

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
            String userName = request.getParameter("userName");
            String userEmail = request.getParameter("userEmail");
            String userPassword = request.getParameter("userPassword");
            String userContactNumber = request.getParameter("userContactNumber");
            String userType = request.getParameter("userType");
            String userAccount = request.getParameter("userAccount");
            String userPosition = request.getParameter("userPosition");

            if (errors.isEmpty()) {
                User newStaff = new User();
                newStaff.setName(userName);
                newStaff.setEmail(userEmail);
                newStaff.setPassword(userPassword);
                newStaff.setPhone(userContactNumber);
                newStaff.setUserType(userType);
                newStaff.setUserAccount(userAccount);
                newStaff.setUserPosition(userPosition);

                staffDAO.addStaff(newStaff);
                request.setAttribute("success", "Staff Record Created!");
            }

        } catch (SQLException ex) {
            errors.add("Error occurred while creating the staff record: " + ex.getMessage());
        }

        request.setAttribute("errors", errors);
        request.getRequestDispatcher("CreateStaffRecord.jsp").forward(request, response);
    }
}
