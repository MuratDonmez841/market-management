package com.cakestudios.market.Api;

import com.cakestudios.market.Dto.ProductDto;
import com.cakestudios.market.Services.Impl.ProductServiceImpl;
import com.cakestudios.market.Util.ApiPaths;
import com.cakestudios.market.Util.Tpage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.Product.CTRL)
public class ProductController {
    @Autowired
    private  ProductServiceImpl productServiceImpl;


    @GetMapping("/getallpage")
    public ResponseEntity<Tpage<ProductDto>> getAllPage(Pageable pageable) {
        Tpage<ProductDto> productDto = this.productServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getByid(@PathVariable(value = "id", required = true) Long id) {
        ProductDto productDto = productServiceImpl.getById(id);
        return ResponseEntity.ok(productDto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Validated @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productServiceImpl.save(productDto));
    }
    @GetMapping("/getlist/{name}/{limit}")
    public ResponseEntity<List<ProductDto>> getList(@PathVariable(value = "name", required = true) String name,
                                                    @PathVariable(value = "limit", required = true) int limit){
        return  ResponseEntity.ok(this.productServiceImpl.getByProductNameContains(name,limit));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "id", required = true) Long id, ProductDto productDto) {
        return ResponseEntity.ok(productServiceImpl.update(id, productDto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(productServiceImpl.Delete(id));
    }

}
