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
            Product product = new Product("The first spear ",2500d);

            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            em.close();
            emf.close();
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

    }
    }
