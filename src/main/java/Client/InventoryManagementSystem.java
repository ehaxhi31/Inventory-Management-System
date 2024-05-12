package Client;

import Dto.ProductDto;
import Entity.Product;
import Service.ProductService;
import Service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add product");
        System.out.println("2. Display All products");
        System.out.println("3. Notify low quantity product");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: 
                createProduct(scanner);
            break;
             
            case 2:
                displayAllProducts();
                break;
            case 3:
                notifyLowStock();
                break;
        }
    }

    private static void displayAllProducts() {
        ProductService productService = new ProductServiceImpl();
        List<Product>productList=
        productService.displayAllProducts();
        for (Product product: productList){
            System.out.println(product);
        }
    }

    private static void notifyLowStock() {
        ProductService productService = new ProductServiceImpl();
        List<Product>productList=productService.notifyLowStock();
        for(Product product:productList){
            System.out.println(product);
        }

    }

    private static void createProduct (Scanner scanner){
        System.out.println("Ju lutem fusni te dhenat e produktit");
        System.out.println("Ju lutem fusni modelin e produktit");
        String model = scanner.next();
        System.out.println("Ju lutem fusni pershkrimin e produktit");
        String description = scanner.next();
        System.out.println("Ju lutem fusni cmimin e produktit");
        Double price = scanner.nextDouble();
        System.out.println("Ju lutem fusni sasine e produktit");
        Integer quantity = scanner.nextInt();

        ProductDto productDto = new ProductDto();
        productDto.setDescription(description);
        productDto.setModel(model);
        productDto.setPrice(price);
        productDto.setQuantity(quantity);

        ProductService productService = new ProductServiceImpl();
        productService.createProduct(productDto);
    }
}
