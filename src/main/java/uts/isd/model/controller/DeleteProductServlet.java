package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.ProductDAO;

public class DeleteProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        try {
            DBConnector dbConnector = new DBConnector();
            productDAO = new ProductDAO(dbConnector);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> errors = new ArrayList<>();

        try {
            String productIDStr = request.getParameter("productID");
            if (!isNumeric(productIDStr)) {
                errors.add("Product ID must contain only numbers.");
            } else {
                int productID = Integer.parseInt(productIDStr);
                if (productDAO.getProductByID(productID) != null) {
                    productDAO.deleteProduct(productID);
                    request.setAttribute("success", "Product deleted!");
                } else {
                    errors.add("No product exists with the given ID.");
                }
            }
        } catch (NumberFormatException ex) {
            errors.add("Invalid number format (numbers only): " + ex.getMessage());
        } catch (SQLException ex) {
            errors.add("Error occurred while deleting the product: " + ex.getMessage());
        }

        request.setAttribute("errors", errors);

        request.getRequestDispatcher("deleteProduct.jsp").forward(request, response);
    }

    // Method to check if a string is numeric
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
