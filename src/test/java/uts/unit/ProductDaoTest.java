package uts.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import uts.isd.model.Product;
import uts.isd.model.dao.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductDaoTest {

    private ProductDAO productDAO;
    private DBConnector dbConnector;

    @BeforeEach
    public void setUp() throws ClassNotFoundException, SQLException {
        dbConnector = new DBConnector();
        productDAO = new ProductDAO(dbConnector);
    }

    @Test
    public void testGetAllProducts() throws SQLException {
        List<Product> products = productDAO.getAllProducts();
        assertNotNull(products);
        assertTrue(products.size() > 0);
    }

    @Test
    public void testAddProduct() throws SQLException {
        Product product = new Product(1001, "Test Product", 10.0, "chair", "Test Description", 100);
        productDAO.addProduct(product);
        Product retrievedProduct = productDAO.getProductByID(1001);
        assertNotNull(retrievedProduct);
    }

    @Test
    public void testSearchProductsByName() throws SQLException {
        List<Product> products = productDAO.searchProductsByName("Wooden Chair");
        assertNotNull(products);
        assertTrue(products.size() > 0);
    }

    @Test
    public void testSearchProductsByKeywordAndFilter() throws SQLException {
        List<Product> products = productDAO.searchProductsByKeywordAndFilter("Wooden Chair", "chair");
        assertNotNull(products);
        assertTrue(products.size() > 0);
    }

    @Test
    public void testGetProductByID() throws SQLException {
        Product product = productDAO.getProductByID(101);
        assertNotNull(product);
    }

    @Test
    public void testCheckProductExistsByName() throws SQLException {
        assertTrue(productDAO.checkProductExistsByName("Wooden Chair"));
    }

    @Test
    public void testUpdateProduct() throws SQLException {
        Product product = productDAO.getProductByID(101);
        assertNotNull(product);
        product.setProductName("Update Chair");
        productDAO.updateProduct(product);
        Product updatedProduct = productDAO.getProductByID(1001);
        assertEquals("Update Chair", updatedProduct.getProductName());
    }

    @Test
    public void testDeleteProduct() throws SQLException {
        productDAO.deleteProduct(1001);
        Product deletedProduct = productDAO.getProductByID(1001);
        assertNull(deletedProduct);
    }
}

