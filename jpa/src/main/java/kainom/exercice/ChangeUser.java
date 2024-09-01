package kainom.exercice;

import basic.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ChangeUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class,7L);
        product.setName("Brás cubas");
        product.setPrice(15000.200);
        em.merge(product);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }




}
