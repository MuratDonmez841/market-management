package com.cakestudios.market.Services.Impl;

import com.cakestudios.market.Dto.ProductDto;
import com.cakestudios.market.Entities.ProductEntity;
import com.cakestudios.market.Repository.ProductRepository;
import com.cakestudios.market.Services.ProductService;
import com.cakestudios.market.Util.Tpage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        this.validateCreateProductRequest(productDto);
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productEntity = productRepository.save(productEntity);
        return modelMapper.map(productEntity, ProductDto.class);
    }

    private void validateCreateProductRequest(ProductDto productDto) {
        if (productDto.getProductBarcodeNo() == null) {
            throw new IllegalArgumentException("Product barcode no can not be null!");
        }
        if (productDto.getProductName() == null) {
            throw new IllegalArgumentException("Product name no can not be null!");
        }
        if (productDto.getProductExpirationDate() == null) {
            throw new IllegalArgumentException("Product expiration date no can not be null!");
        }
    }

    @Override
    public ProductDto getById(Long id) {

        ProductEntity productEntity = productRepository.getOne(id);
        return modelMapper.map(productEntity, ProductDto.class);
    }

    @Override
    public List<ProductDto> getByProductNameContains(String productName , int limit) {

        List<ProductEntity> entities = productRepository.getByProductName(productName);
        entities.stream()
                .forEach(System.out::println);
        if (entities == null) {
            throw new IllegalArgumentException("Product name can not be find!");
        }
        return entities.stream()
                .map(p ->  modelMapper.map(p, ProductDto.class))
                .filter(x -> x.getId()>limit)
                .collect(Collectors.toList());
    }

    @Override
    public ProductEntity getByProductBarcodeNo(String productBarcodeNo) {
        ProductEntity productEntity = productRepository.getByProductBarcodeNo(productBarcodeNo);
        if (productEntity == null) {
            throw new IllegalArgumentException("Product barcode no can not be find!");
        }
        return productEntity;
    }

    @Override
    public Tpage<ProductDto> getAllPageable(Pageable pageable) {
        Page<ProductEntity> page = productRepository.findAll(pageable);
        Tpage<ProductDto> tpage = new Tpage<>();
        tpage.setStats(page, Arrays.asList(modelMapper.map(page.getContent(), ProductDto.class)));
        return tpage;
    }

    @Override
    public Boolean delete(ProductEntity productEntity) {
        return null;
    }

    public Boolean Delete(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException("Product id not found!");
        }
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        ProductEntity productEntity = productRepository.getOne(id);
        if (productEntity == null) {
            throw new IllegalArgumentException("Product not found!");
        }
        ProductEntity productCheck = productRepository.getByProductBarcodeNoAndIdNot(productDto.getProductBarcodeNo(), id);
        if (productCheck == null) {
            throw new IllegalArgumentException("Product barcode no already exist!");
        }
        productEntity.setProductStocksNumber(productDto.getProductStocksNumber());
        productEntity.setProductExpirationDate(productDto.getProductExpirationDate());
        productEntity.setProductName(productDto.getProductName());
        productRepository.save(productEntity);
        return modelMapper.map(productEntity, ProductDto.class);
    }
}
