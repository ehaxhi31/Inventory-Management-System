package Dao;

import Entity.Product;

import java.util.List;

public interface ProductDao {
    void save(Product product);

    List<Product> findAll();

    List<Product> findLowStockProduck(Integer quantity);
}
