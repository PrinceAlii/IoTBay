package uts.isd.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.User;

@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the search parameters
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        // Create a DAO object
        Connection conn = (Connection) getServletContext().getAttribute("dbConn");
        SystemAdminDAO dao = new SystemAdminDAO(conn);

        // Fetch the users based on the search parameters
        ArrayList<User> users = dao.fetchUsers(name, phone);

        // Set the users list as a request attribute
        request.setAttribute("users", users);

        // Forward the request to the ViewUsers.jsp
        request.getRequestDispatcher("ViewUsers.jsp").forward(request, response);
    }
}
