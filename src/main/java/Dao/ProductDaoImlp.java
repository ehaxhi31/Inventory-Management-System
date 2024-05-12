package Dao;

import Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.DataException;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDaoImlp implements ProductDao{

    private final SessionFactory sessionFactory;

    public ProductDaoImlp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void save (Product product) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (DataException de){
            System.out.println(de.getCause());
        }
    }
    @Override
    public List<Product> findAll(){
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT p FROM Product p",
                Product.class).getResultList();
    }

    @Override
    public List<Product> findLowStockProduck(Integer quantity) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(
                "from Product p Where p.quantity < (:q)", Product.class);
        query.setParameter("q",quantity);
        return query.getResultList();
    }
}
