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
            String filter = request.getParameter("filter");
            List<Product> products;

            if ((searchKeyword != null && !searchKeyword.isEmpty()) || (filter != null && !filter.isEmpty())) {
                if (filter != null && !filter.isEmpty()) {
                    // If a filter is selected, search with both search keyword and filter
                    products = productDAO.searchProductsByKeywordAndFilter(searchKeyword, filter);
                } else {
                    // If no filter is selected, search only with the search keyword
                    products = productDAO.searchProductsByName(searchKeyword);
                }
            } else {
                // If neither search keyword nor filter is provided, fetch all products
                products = productDAO.getAllProducts();
            }

            // Set image URL for each product
            for (Product product : products) {
                product.setImageUrl("https://static.vecteezy.com/system/resources/previews/032/447/246/non_2x/a-modern-kitchen-and-dining-area-with-a-view-of-the-mountains-ai-generated-free-photo.jpg");
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
