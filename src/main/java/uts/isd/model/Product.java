package uts.isd.model;

import java.io.Serializable;

public class Product implements Serializable {

  private int productID;
  private String productName;
  private double productPrice; 
  private String productType;
  private String productDescription;
  private int stockLevel;
  private String imageUrl;

  public Product() {
  }

  public Product(int _productID, String _productName, double _productPrice, String _productType,
    String _productDescription, int _stockLevel) {
    this.productID = _productID;
    this.productName = _productName;
    this.productPrice = _productPrice;
    this.productType = _productType;
    this.productDescription = _productDescription;
    this.stockLevel = _stockLevel;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
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

  public int getStockLevel() {
    return stockLevel;
  }

  public void setStockLevel(int stockLevel) {
    this.stockLevel = stockLevel;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
  }
}
