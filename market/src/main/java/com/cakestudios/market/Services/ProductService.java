package com.cakestudios.market.Services;

import com.cakestudios.market.Dto.ProductDto;
import com.cakestudios.market.Entities.ProductEntity;
import com.cakestudios.market.Util.Tpage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto productDto);

    ProductDto getById(Long id);

    List<ProductDto> getByProductNameContains(String productName,int limit);

    ProductEntity getByProductBarcodeNo(String productBarcodeNo);

    Tpage<ProductDto> getAllPageable(Pageable pageable);

    Boolean delete(ProductEntity productEntity);


    ProductDto update(Long id, ProductDto productDto);
}
