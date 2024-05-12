package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Order;
import uts.isd.model.PaymentDetails;
import uts.isd.model.User;
import uts.isd.model.dao.PaymentDAO;

public class PaymentHistoryServlet extends HttpServlet {

    private PaymentDAO paymentDAO;
    
    @Override
    public void init() throws ServletException {
        try {
            paymentDAO = new PaymentDAO();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException("Failed to initialize PaymentDAO", ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // forward to doPost because something is doing a get request
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
    
        try {
            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }
    
            int paymentID = 0;
            String paymentIDParam = request.getParameter("searchPaymentID");

            if (paymentIDParam != null && !paymentIDParam.isEmpty()) {
                paymentID = Integer.parseInt(paymentIDParam);
            }
    
            // if searching with paymentID
            List<Order> orders;
            if (paymentID != 0) {
                orders = paymentDAO.getPaymentHistory(user.getUserID(), paymentID);
            } else {
                // if not searching with payment ID
                orders = paymentDAO.getPaymentHistory(user.getUserID(), 0);
            }
    
            request.setAttribute("orders", orders);
    
            request.getRequestDispatcher("paymentHistory.jsp").forward(request, response);
    
        } catch (SQLException ex) {
            Logger.getLogger(PaymentHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while retrieving payment history");
        }
    }
    

}
