package kainom.exercice;

import basic.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GetAllProduct {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
            EntityManager em = emf.createEntityManager();

            String jpql = "select u from Product u";
            TypedQuery<Product> query = em.createQuery(jpql,Product.class);
            query.setMaxResults(3);
            query.getResultList().stream().map(Product::getName).forEach(System.out::println);




            em.close();
            emf.close();
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

    }
    }
