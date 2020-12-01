package com.cakestudios.market.Entities;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "barcode_no")
    private String productBarcodeNo;
    @Column(name = "stocks_number")
    private Long productStocksNumber;
    @Column(name = "expiration_date")
    private Date productExpirationDate;
    @Column(name = "product_brand")
    private String productBrand;
    @JoinColumn(name = "category")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private CategoryEntity category;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String productName, String productBarcodeNo, Long productStocksNumber, Date productExpirationDate, String productBrand, CategoryEntity category) {
        this.id = id;
        this.productName = productName;
        this.productBarcodeNo = productBarcodeNo;
        this.productStocksNumber = productStocksNumber;
        this.productExpirationDate = productExpirationDate;
        this.productBrand = productBrand;
        this.category = category;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productBarcodeNo, that.productBarcodeNo) &&
                Objects.equals(productStocksNumber, that.productStocksNumber) &&
                Objects.equals(productExpirationDate, that.productExpirationDate) &&
                Objects.equals(productBrand, that.productBrand) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productBarcodeNo, productStocksNumber, productExpirationDate, productBrand, category);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productBarcodeNo='" + productBarcodeNo + '\'' +
                ", productStocksNumber=" + productStocksNumber +
                ", productExpirationDate=" + productExpirationDate +
                ", productBrand='" + productBrand + '\'' +
                ", category=" + category +
                '}';
    }

    public Date getProductExpirationDate() {
        return productExpirationDate;
    }

    public void setProductExpirationDate(Date productExpirationDate) {
        this.productExpirationDate = productExpirationDate;
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

    public String getProductBarcodeNo() {
        return productBarcodeNo;
    }

    public void setProductBarcodeNo(String barcodeNo) {
        this.productBarcodeNo = barcodeNo;
    }

    public Long getProductStocksNumber() {
        return productStocksNumber;
    }

    public void setProductStocksNumber(Long stocksNumber) {
        this.productStocksNumber = stocksNumber;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
