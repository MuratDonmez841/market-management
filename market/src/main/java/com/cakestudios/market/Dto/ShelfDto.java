package com.cakestudios.market.Dto;

public class ShelfDto {
    private Long id;
    private String shelfName;
    private String shelfNo;

    public ShelfDto() {
    }

    public ShelfDto(Long id, String shelfName, String shelfNo) {
        this.id = id;
        this.shelfName = shelfName;
        this.shelfNo = shelfNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public String getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(String shelfNo) {
        this.shelfNo = shelfNo;
    }
}
