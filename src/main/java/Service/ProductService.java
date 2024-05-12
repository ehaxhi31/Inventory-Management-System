package Service;

import Dto.ProductDto;
import Entity.Product;

import java.util.List;

public interface ProductService {
    void createProduct(ProductDto productDto);

    List<Product> displayAllProducts();

    List<Product> notifyLowStock();
}
