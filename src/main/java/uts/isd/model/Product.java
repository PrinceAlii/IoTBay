package uts.isd.model;

import java.io.Serializable;

public class Product implements Serializable {

  private String productID;
  private String productName;
  private double productPrice; 
  private String productType;
  private String productDescription;
  private int productQuantity;

  public Product() {
  }

  public Product(String _productID, String _productName, double _productPrice, String _productType,
                 String _productDescription, int _productQuantity) {
    this.productID = _productID;
    this.productName = _productName;
    this.productPrice = _productPrice;
    this.productType = _productType;
    this.productDescription = _productDescription;
    this.productQuantity = _productQuantity;
  }

  // Getters and setters (same format as existing ones)

  public String getProductID() {
    return productID;
  }

  public void setProductID(String productID) {
    this.productID = productID;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public int getProductQuantity() {
    return productQuantity;
  }

  public void setProductQuantity(int productQuantity) {
    this.productQuantity = productQuantity;
  }
}
