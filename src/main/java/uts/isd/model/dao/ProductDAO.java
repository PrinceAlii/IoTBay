package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uts.isd.model.Product;

public class ProductDAO {
    private final Connection conn;

    public ProductDAO(DBConnector dbConnector) {
        this.conn = dbConnector.openConnection();
    }

    // Method to retrieve a list of all products
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Products";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductType(rs.getString("productType"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setStockLevel(rs.getInt("stockLevel"));
                products.add(product);
            }
        }
        return products;
    }

    // Method to search products by name
    public List<Product> searchProductsByName(String keyword) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product WHERE ProductName LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductID(rs.getInt("productID"));
                    product.setProductName(rs.getString("productName"));
                    product.setProductPrice(rs.getDouble("productPrice"));
                    product.setProductType(rs.getString("productType"));
                    product.setProductDescription(rs.getString("productDescription"));
                    product.setStockLevel(rs.getInt("stockLevel"));
                    products.add(product);
                }
            }
        }
        return products;
    }
}
