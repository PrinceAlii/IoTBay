package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.User;
import uts.isd.model.dao.AdminStaffDAO;
import uts.isd.model.dao.DBConnector;

public class ViewStaffServlet extends HttpServlet {

    private AdminStaffDAO adminStaffDAO;

    @Override
    public void init() throws ServletException {
        try {
            DBConnector dbConnector = new DBConnector();
            adminStaffDAO = new AdminStaffDAO(dbConnector);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String searchKeyword = request.getParameter("searchName"); // Search by name
            String filter = request.getParameter("searchUserPosition"); // Filter by position

            List<User> staffList;

            if ((searchKeyword != null && !searchKeyword.isEmpty()) || (filter != null && !filter.isEmpty())) {
                if (filter != null && !filter.isEmpty()) { // Filter by position
                    staffList = adminStaffDAO.searchStaffByNameAndPosition(searchKeyword, filter);
                } else { // Search by name
                    staffList = adminStaffDAO.searchStaffByName(searchKeyword);
                }
            } else {
                staffList = adminStaffDAO.fetchStaff(); // Fetch all staff
            }

            if (staffList.isEmpty()) {
                request.setAttribute("error", "No staff found.");
            } else {
                request.setAttribute("staffList", staffList);
            }

            request.getRequestDispatcher("ViewStaff.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

}
