package Service;

import Confing.HibernateConfig;
import Converter.ProductConverter;
import Dao.ProductDao;
import Dao.ProductDaoImlp;
import Dto.ProductDto;
import Entity.Product;
import Validator.ProductValidator;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final Integer quantity = 5;
    private final SessionFactory sessionFactory =
            HibernateConfig.getSessionFactory();

    @Override
    public void createProduct(ProductDto productDto) {
        ProductValidator.validateProduct(productDto);
        Product product = ProductConverter.convertToEntity(productDto);

        ProductDao productDao = new ProductDaoImlp(sessionFactory);
        productDao.save(product);

    }

    @Override
    public List<Product> displayAllProducts() {
        ProductDao productDao = new ProductDaoImlp(sessionFactory);
        return productDao.findAll();
    }



    @Override
    public List<Product> notifyLowStock() {
        ProductDao productDao = new ProductDaoImlp(sessionFactory);
        return productDao.findLowStockProduck(quantity);
    }
}
