package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Order;
import uts.isd.model.User;
import uts.isd.model.dao.OrderDAO;

public class OrderServlet extends HttpServlet {

    private OrderDAO orderDAO;

    @Override
    public void init() throws ServletException {
        try {
            orderDAO = new OrderDAO();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException("Failed to initialize OrderDAO", ex);
        }
    }

    // forward to doPost
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //check user login
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String orderIDStr = request.getParameter("orderID");
        String orderDateStr = request.getParameter("orderDate");
        Integer orderID = null;
        Date orderDate = null;

        if (orderIDStr != null && !orderIDStr.isEmpty()) {
            try {
                orderID = Integer.parseInt(orderIDStr);
            } catch (NumberFormatException e) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, "Invalid order ID format", e);
            }
        }
        if (orderDateStr != null && !orderDateStr.isEmpty()) {
            try {
                orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(orderDateStr);
            } catch (ParseException e) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, "Invalid date format", e);
            }
        }
        
        // get order detail for the user
        try {
            List<Order> orderDetail = orderDAO.findOrders(user.getUserID(), orderID, orderDate);
            request.setAttribute("orderDetail", orderDetail);
            request.getRequestDispatcher("orderManagement.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while retrieving orders.");
        }
    }

}
