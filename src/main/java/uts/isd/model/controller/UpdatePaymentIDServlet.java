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
import uts.isd.model.dao.UserDAO;


public class UpdatePaymentIDServlet extends HttpServlet {
    
    private PaymentDAO paymentDAO;
    private UserDAO userDAO;
    
    @Override
    public void init() throws ServletException {

        try {
            paymentDAO = new PaymentDAO();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException("Failed to initialize PaymentDAO", ex);
        }

        try {
            userDAO = new UserDAO();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdatePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException("Failed to initialize UserDAO", ex);
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
    
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    
        try {

            String paymentMethod = request.getParameter("paymentMethod");
            String cardNumber = request.getParameter("cardNumber");

            Object attributeValue = session.getAttribute("paymentIDToUpdate");
            String sessionPaymentID = (String) attributeValue;
            

            int paymentID = Integer.parseInt(sessionPaymentID);

                
            System.out.println("Extracted paymentID: " + paymentID);
    

            paymentDAO.updatePayment(paymentID, paymentMethod, cardNumber);
    
            List<PaymentDetails> paymentMethods = paymentDAO.findPaymentByUser(user.getUserID());
            request.setAttribute("paymentMethods", paymentMethods);

            request.getRequestDispatcher("paymentDetails?action=success").forward(request, response);
            
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UpdatePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request");
        }
    }
    
    
    
    
}
