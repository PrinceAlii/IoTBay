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

import uts.isd.model.PaymentDetails;
import uts.isd.model.User;
import uts.isd.model.dao.PaymentDAO;

public class PaymentDetailsServlet extends HttpServlet {

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
    public void destroy() {
        try {
            paymentDAO.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
        // login check
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    
        try {
            // get all saved payment methods for user
            List<PaymentDetails> paymentMethods = paymentDAO.findPaymentByUser(user.getUserID());
    
            // debug
            System.out.println("Retrieved Payment Methods: " + paymentMethods);
    
            // Set paymentMethods attribute in request
            request.setAttribute("paymentMethods", paymentMethods);
    
            // Forward to view
            request.getRequestDispatcher("paymentDetails.jsp").forward(request, response);
    
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Handle exception
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while retrieving payment details");
        }
    }
    
}
