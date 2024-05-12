package Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private Integer quantity;
    private Double price;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAT;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getQuanity() {
        return quantity;
    }

    public void setQuanity(Integer quanity) {
        this.quantity = quanity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAT = createdAT;
    }

    public LocalDateTime getUpdatedAT() {
        return updatedAT;
    }

    public void setUpdatedAT(LocalDateTime updatedAT) {
        this.updatedAT = updatedAT;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", quanity=" + quantity +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createdAT=" + createdAT +
                ", updatedAT=" + updatedAT +
                '}';
    }

    public void setQuantity(Integer quantity) {
    }
}
