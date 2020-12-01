package com.cakestudios.market.Dto;

import com.cakestudios.market.Entities.CategoryEntity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class ProductDto {
    private Long id;
    private String productName;
    private String productBarcodeNo;
    private Long productStocksNumber;
    private Date productExpirationDate;
    private CategoryDto category;

    public ProductDto() {
    }

    public ProductDto(Long id, String productName, String productBarcodeNo, Long productStocksNumber, Date productExpirationDate, CategoryDto category) {
        this.id = id;
        this.productName = productName;
        this.productBarcodeNo = productBarcodeNo;
        this.productStocksNumber = productStocksNumber;
        this.productExpirationDate = productExpirationDate;
        this.category = category;
    }

    public String getProductBarcodeNo() {
        return productBarcodeNo;
    }

    public void setProductBarcodeNo(String productBarcodeNo) {
        this.productBarcodeNo = productBarcodeNo;
    }

    public Long getProductStocksNumber() {
        return productStocksNumber;
    }

    public void setProductStocksNumber(Long productStocksNumber) {
        this.productStocksNumber = productStocksNumber;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public Date getProductExpirationDate() {
        return productExpirationDate;
    }

    public void setProductExpirationDate(Date productExpirationDate) {
        this.productExpirationDate = productExpirationDate;
    }
}
