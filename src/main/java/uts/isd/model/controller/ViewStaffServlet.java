package uts.isd.model.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Staff;
import uts.isd.model.dao.StaffDao;
import uts.isd.model.dao.DaoFactory;

public class ViewStaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Connection conn = (Connection) session.getAttribute("conn");

        // Create an instance of StaffDao using DaoFactory
        StaffDao staffDao = DaoFactory.getStaffDao();

        try {
            // Fetch the staff members
            ArrayList<Staff> staffList = staffDao.fetchStaff();

            // Set the staff list as a request attribute
            request.setAttribute("staffList", staffList);

            // Forward the request to the ViewStaff.jsp
            request.getRequestDispatcher(" ViewStaff.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle the SQLException here
            System.err.println("An error occurred while fetching staff: " + e.getMessage());
            // You can also display a user-friendly message to the user on the JSP
            // by setting a request attribute here
        }
    }
}
