package kainom.exercice;

import basic.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
            EntityManager em = emf.createEntityManager();

            Product product = em.find(Product.class, 2L);
            System.out.println(product.getName());

            em.close();
            emf.close();
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

    }
    }
