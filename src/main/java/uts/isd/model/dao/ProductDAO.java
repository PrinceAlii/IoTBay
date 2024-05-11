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
        String query = "SELECT * FROM Product";
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

    // Method to search products by name and filter
    public List<Product> searchProductsByKeywordAndFilter(String keyword, String filter) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product WHERE productName LIKE ? AND productType = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, filter);
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

    // Method to add a new product
    public void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO Product (productID, productName, productPrice, productType, productDescription, stockLevel) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, product.getProductID());
            stmt.setString(2, product.getProductName());
            stmt.setDouble(3, product.getProductPrice());
            stmt.setString(4, product.getProductType());
            stmt.setString(5, product.getProductDescription());
            stmt.setInt(6, product.getStockLevel());
            stmt.executeUpdate();
        }
    }

    // Method to check if a product with given ID already exists
    public Product getProductByID(int productID) throws SQLException {
        String query = "SELECT * FROM Product WHERE productID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();
                    product.setProductID(rs.getInt("productID"));
                    product.setProductName(rs.getString("productName"));
                    product.setProductPrice(rs.getDouble("productPrice"));
                    product.setProductType(rs.getString("productType"));
                    product.setProductDescription(rs.getString("productDescription"));
                    product.setStockLevel(rs.getInt("stockLevel"));
                    return product;
                }
            }
        }
        return null;
    }

    // Method to check if a product with the given name already exists
    public boolean checkProductExistsByName(String productName) throws SQLException {
        String query = "SELECT COUNT(*) FROM Product WHERE productName = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, productName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    // Method to update an existing product
    public void updateProduct(Product product) throws SQLException {
        String query = "UPDATE Product SET productName = ?, productPrice = ?, productType = ?, productDescription = ?, stockLevel = ? WHERE productID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getProductName());
            stmt.setDouble(2, product.getProductPrice());
            stmt.setString(3, product.getProductType());
            stmt.setString(4, product.getProductDescription());
            stmt.setInt(5, product.getStockLevel());
            stmt.setInt(6, product.getProductID());
            stmt.executeUpdate();
        }
    }

    // Add method to delete a product by ID
    public void deleteProduct(int productID) throws SQLException {
        String query = "DELETE FROM Product WHERE productID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productID);
            stmt.executeUpdate();
        }
    }

}
