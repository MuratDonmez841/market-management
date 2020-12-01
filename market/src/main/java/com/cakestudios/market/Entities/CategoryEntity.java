package com.cakestudios.market.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "category_name")
    private String categoryName;
    @JoinColumn(name = "shelf")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private ShelfEntity shelf;

    public CategoryEntity() {
    }

    public CategoryEntity(Long id, String categoryName, ShelfEntity shelf) {
        this.id = id;
        this.categoryName = categoryName;
        this.shelf = shelf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(shelf, that.shelf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, shelf);
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", shelf=" + shelf +
                '}';
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

    public ShelfEntity getShelf() {
        return shelf;
    }

    public void setShelf(ShelfEntity shelf) {
        this.shelf = shelf;
    }
}
