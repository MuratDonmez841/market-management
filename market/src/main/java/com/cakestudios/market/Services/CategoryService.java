package com.cakestudios.market.Services;

import com.cakestudios.market.Dto.CategoryDto;
import com.cakestudios.market.Entities.CategoryEntity;
import com.cakestudios.market.Util.Tpage;

import java.awt.print.Pageable;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);

    CategoryDto getById(Long id);

    Tpage<CategoryDto> getAllPageable(Pageable pageable);

    Boolean delete(CategoryEntity categoryEntity);

    CategoryDto update(Long id, CategoryDto categoryDto);

}
