package Converter;

import Dto.ProductDto;
import Entity.Product;

public class ProductConverter {
    public static Product convertToEntity(ProductDto productDto){
        Product product = new Product();
        product.setModel(productDto.getModel());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        return product;
    }
}
