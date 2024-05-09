package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.Product;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.ProductDAO;

public class ProductServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            String searchKeyword = request.getParameter("search");
            List<Product> products;
            if (searchKeyword != null && !searchKeyword.isEmpty()) {
                products = productDAO.searchProductsByName(searchKeyword);
            } else {
                products = productDAO.getAllProducts();
            }
            if (products.isEmpty()) {
                request.setAttribute("error", "No products found.");
            } else {
                request.setAttribute("products", products);
            }
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
