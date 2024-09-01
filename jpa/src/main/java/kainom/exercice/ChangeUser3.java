package kainom.exercice;

import basic.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ChangeUser3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        Product product = em.find(Product.class,7);
        em.detach(product);  // get out the result of transaction ,of state manager
        product.setName("Dom casmurro");
        em.getTransaction().begin();

        em.close();
        emf.close();

    }
}
