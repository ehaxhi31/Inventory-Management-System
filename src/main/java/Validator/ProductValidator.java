package Validator;

import Dto.ProductDto;

public class ProductValidator {
    public static void validateProduct(ProductDto productDto){
        if(productDto.getModel().isBlank()){
            throw new IllegalArgumentException ("Ju lutem modeli "
                    + "i produkt eshte i nevojshem");
        }
        if(productDto.getPrice()<=0D){
            throw new IllegalArgumentException("Ju lutem cmimi "
                    + "i produktit s'mund te jete 0 ose me vlera"
                    + "negative");
        }
    }
}
