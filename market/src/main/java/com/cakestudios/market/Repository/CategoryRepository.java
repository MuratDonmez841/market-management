package com.cakestudios.market.Repository;

import com.cakestudios.market.Entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<CategoryEntity,Long> {

}
