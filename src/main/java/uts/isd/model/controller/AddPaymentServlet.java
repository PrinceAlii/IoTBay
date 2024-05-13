package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.User;
import uts.isd.model.dao.PaymentDAO;

public class AddPaymentServlet extends HttpServlet {
    
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
        
            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }

    
            // what we actually need
            String paymentMethod = request.getParameter("paymentMethod");
            String cardNumber = request.getParameter("cardNumber");

            // just here for severside validation
            String expiryDate = request.getParameter("expiryDate");
            String cvv = request.getParameter("cvv");

            System.out.println("Payment Method: " + paymentMethod);
            System.out.println("Card Number: " + cardNumber);
            System.out.println("Expiry Date: " + expiryDate);
            System.out.println("CVV: " + cvv);

            List<String> errors = new ArrayList<>();

            if (paymentMethod == null || paymentMethod.isEmpty()) {
                errors.add("You must choose your card issuer");
            }

            if (cardNumber == null || cardNumber.isEmpty()) {
                errors.add("You must enter your card number");
            } else if (!isValidCardNumber(cardNumber)) {
                errors.add("You must enter a 16 digit (MasterCard & Visa) or 15 digit (American Express) card number.");
            }

            if (expiryDate == null || expiryDate.isEmpty()) {
                errors.add("You must enter your cards expiry date.");
            } else if (!isValidExpiryDate(expiryDate)) {
                errors.add("Invalid expiry date. Ensure you enter your expiry date in the format MM/YYYY, otherwise your card may be expired.");
            }
            
            if (cvv == null || cvv.isEmpty()) {
                errors.add("You must enter your cards CVV.");


            } else if (!isValidCVV(cvv)) {
                errors.add("Invalid CVV. Must be 3 digits.");
            }
        
            if (!errors.isEmpty()) {
                // forward back to page passing through error message
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("addPayment.jsp").forward(request, response);
                return;
            }
        

            try {
                paymentDAO.addPayment(paymentMethod, cardNumber, user.getUserID());
        
                response.sendRedirect("paymentDetails?paymentAdded=true");
            } catch (SQLException ex) {
                Logger.getLogger(AddPaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while adding payment details. Please contact our support team.");
            }
    }


    // methods for validation
    
    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{15,16}");
    }
    

    private boolean isValidExpiryDate(String expiryDate) {
        if (expiryDate.matches("(0[1-9]|1[0-2])/\\d{4}")) {
    
            // check if expiry date is before 05/2024
            String[] parts = expiryDate.split("/");
            int month = Integer.parseInt(parts[0]);
            int year = Integer.parseInt(parts[1]);
            if (year < 2024 || (year == 2024 && month < 5)) {
                return false;
            }
            return true; 
        }
        return false; 
    }

    
    private boolean isValidCVV(String cvv) {
        return cvv.matches("\\d{3}");
    }
    


}
