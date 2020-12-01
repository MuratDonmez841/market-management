package com.cakestudios.market.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shelf")
public class ShelfEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "shelf_name")
    private String shelfName;
    @Column(name = "shelf_no")
    private String shelfNo;

    public ShelfEntity() {
    }

    public ShelfEntity(Long id, String shelfName, String shelfNo) {
        this.id = id;
        this.shelfName = shelfName;
        this.shelfNo = shelfNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelfEntity that = (ShelfEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(shelfName, that.shelfName) &&
                Objects.equals(shelfNo, that.shelfNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shelfName, shelfNo);
    }

    @Override
    public String toString() {
        return "ShelfEntity{" +
                "id=" + id +
                ", shelfName='" + shelfName + '\'' +
                ", shelfNo='" + shelfNo + '\'' +
                '}';
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
