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

public class CreateProductServlet extends HttpServlet {

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
            int productID = Integer.parseInt(request.getParameter("productID"));
            String productName = request.getParameter("productName");
            double productPrice = Double.parseDouble(request.getParameter("productPrice"));
            String productType = request.getParameter("productType");
            String productDescription = request.getParameter("productDescription");
            int stockLevel = Integer.parseInt(request.getParameter("stockLevel"));

            if (productID <= 0) {
                errors.add("Product ID must be a positive integer.");
            }
            if (productDAO.getProductByID(productID) != null) {
                errors.add("Product with the same ID already exists.");
            }
            if (productDAO.checkProductExistsByName(productName)) {
                errors.add("Product with the same name already exists.");
            }
            if (productName.isEmpty()) {
                errors.add("Product name cannot be empty.");
            }
            if (productPrice <= 0) {
                errors.add("Product price must be a positive number.");
            }
            if (productType.isEmpty()) {
                errors.add("Product type cannot be empty.");
            }
            if (productDescription.isEmpty()) {
                errors.add("Product description cannot be empty.");
            }
            if (stockLevel <= 0) {
                errors.add("Stock level must be a positive integer.");
            }

            if (errors.isEmpty()) {
                Product newProduct = new Product(productID, productName, productPrice, productType, productDescription, stockLevel);
                productDAO.addProduct(newProduct);
                request.setAttribute("success", "Product Created!");
            }

        } catch (NumberFormatException ex) {
            errors.add("Invalid number format (numbers only): " + ex.getMessage());
        } catch (SQLException ex) {
            errors.add("Error occurred while creating the product: " + ex.getMessage());
        }

        request.setAttribute("errors", errors);

        request.getRequestDispatcher("createProduct.jsp").forward(request, response);
    }

}
