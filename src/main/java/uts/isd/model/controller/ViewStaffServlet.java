package uts.isd.model.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.Staff;
import uts.isd.model.db.DBConnector;

public class ViewStaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnector.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Staff";
            rs = stmt.executeQuery(query);

            ArrayList<Staff> staffList = new ArrayList<>();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String userType = rs.getString("userType");
                String userAccount = rs.getString("userAccount");
                boolean userStatus = rs.getBoolean("userStatus");

                Staff staff = new Staff(userID, name, email, userType, userAccount, userStatus);
                staffList.add(staff);
            }

            request.setAttribute("staffList", staffList);
            request.getRequestDispatcher("ViewStaff.jsp").forward(request, response);
        } catch (SQLException e) {
            System.err.println("An error occurred while fetching staff members: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
