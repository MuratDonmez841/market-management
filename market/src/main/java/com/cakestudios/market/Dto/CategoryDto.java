package com.cakestudios.market.Dto;

public class CategoryDto {
    private Long id;
    private String categoryName;
    private ShelfDto shelfDto;

    public CategoryDto() {
    }

    public CategoryDto(Long id, String categoryName, ShelfDto shelfDto) {
        this.id = id;
        this.categoryName = categoryName;
        this.shelfDto = shelfDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ShelfDto getShelfDto() {
        return shelfDto;
    }

    public void setShelfDto(ShelfDto shelfDto) {
        this.shelfDto = shelfDto;
    }
}
