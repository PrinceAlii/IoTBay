package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.isd.model.Product;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.ProductDAO;

public class UpdateProductServlet extends HttpServlet {

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
                Product existingProduct = productDAO.getProductByID(productID);

                if (existingProduct == null) {
                    errors.add("Product with ID " + productID + " does not exist.");
                } else {
                    String productName = request.getParameter("productName");
                    if (productName != null && !productName.isEmpty()) {
                        existingProduct.setProductName(productName);
                    }

                    String productType = request.getParameter("productType");
                    if (productType != null && !productType.isEmpty()) {
                        existingProduct.setProductType(productType);
                    }

                    String productDescription = request.getParameter("productDescription");
                    if (productDescription != null && !productDescription.isEmpty()) {
                        existingProduct.setProductDescription(productDescription);
                    }

                    String productPriceStr = request.getParameter("productPrice");
                    if (!productPriceStr.matches("\\d+(\\.\\d+)?")) { // Updated regex
                        errors.add("Product price must be a number. It can include a decimal point (.) for cents.");
                    } else {
                        double productPrice = Double.parseDouble(productPriceStr);
                        if (productPrice <= 0) {
                            errors.add("Product price must be a positive number.");
                        } else {
                            existingProduct.setProductPrice(productPrice);
                        }
                    }

                    String stockLevelStr = request.getParameter("stockLevel");
                    if (!isNumeric(stockLevelStr)) {
                        errors.add("Stock level must contain only numbers.");
                    } else {
                        int stockLevel = Integer.parseInt(stockLevelStr);
                        if (stockLevel <= 0) {
                            errors.add("Stock level must be a positive integer.");
                        } else {
                            existingProduct.setStockLevel(stockLevel);
                        }
                    }

                    // If there are no errors, update the product
                    if (errors.isEmpty()) {
                        productDAO.updateProduct(existingProduct);
                        request.setAttribute("success", "Product Updated!");
                    }
                }
            }

        } catch (NumberFormatException ex) {
            errors.add("Invalid number format (numbers only): " + ex.getMessage());
        } catch (SQLException ex) {
            errors.add("Error occurred while updating the product: " + ex.getMessage());
        }

        // Set the list of errors as a request attribute
        request.setAttribute("errors", errors);

        // Forward the request to the updateProduct.jsp
        request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
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