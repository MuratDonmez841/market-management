package com.cakestudios.market.Repository;

import com.cakestudios.market.Entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity getByProductBarcodeNo(String productBarcodeNo);

    List<ProductEntity> getByProductName(String productName);

    Page<ProductEntity> findAll(Pageable pageable);

    List<ProductEntity> findAll(Sort sort);

    ProductEntity getByProductBarcodeNoAndIdNot(String productBarcodeNo, Long id);

}
