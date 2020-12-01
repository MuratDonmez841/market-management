package com.cakestudios.market.Services;

import com.cakestudios.market.Dto.ShelfDto;
import com.cakestudios.market.Util.Tpage;

import java.awt.print.Pageable;

public interface ShelfService {
    ShelfDto save(ShelfDto shelfDto);

    ShelfDto getById(Long id);

    Tpage<ShelfDto> getAllPageable(Pageable pageable);

    Boolean delete(ShelfDto shelfDto);

    ShelfDto update(Long id, ShelfDto shelfDto);


}
