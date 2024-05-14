package uts.unit;

import org.junit.jupiter.api.Test;

import uts.isd.model.dao.ProductDAO;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.Product;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoTest {
    
    private DBConnector connector;
    private Connection conn;
    private ProductDAO productDAO;

    public ProductDaoTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        productDAO = new ProductDAO(connector);
    }
    
    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    @Test
    public void testGetAllProducts() throws SQLException {
        List<Product> products = productDAO.getAllProducts();
        assertNotNull(products);
    }

    @Test
    public void testSearchProductsByName() throws SQLException {
        List<Product> products = productDAO.searchProductsByName("test");
        assertNotNull(products);
    }

    @Test
    public void testSearchProductsByKeywordAndFilter() throws SQLException {
        List<Product> products = productDAO.searchProductsByKeywordAndFilter("test", "type");
        assertNotNull(products);
    }

    @Test
    public void testAddProduct() throws SQLException {
        Product product = new Product();
        product.setProductID(1);
        product.setProductName("test product");
        product.setProductPrice(10.0); 
        product.setProductType("Type");
        product.setProductDescription("Description");
        product.setStockLevel(10); 
        productDAO.addProduct(product);
    }

    @Test
    public void testGetProductByID() throws SQLException {
        Product product = productDAO.getProductByID(1); 
        assertNotNull(product);
    }

    @Test
    public void testCheckProductExistsByName() throws SQLException {
        boolean exists = productDAO.checkProductExistsByName("test product"); 
        assertNotNull(exists);
    }

    @Test
    public void testUpdateProduct() throws SQLException {
        Product product = new Product();
        product.setProductID(1); 
        product.setProductName("Updated Product");
        product.setProductPrice(15.0); 
        product.setProductType("Updated Type");
        product.setProductDescription("Updated Description");
        product.setStockLevel(20); 
        productDAO.updateProduct(product);
    }

    @Test
    public void testDeleteProduct() throws SQLException {
        productDAO.deleteProduct(1); 
    }
}
