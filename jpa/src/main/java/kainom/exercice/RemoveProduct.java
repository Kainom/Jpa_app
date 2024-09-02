package kainom.exercice;

import basic.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RemoveProduct {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        Product product =  em.find(Product.class,8);
        if(product != null){
            em.getTransaction().begin();
            em.remove(product);
        em.getTransaction().commit();
        }
        emf.close();

    }

}
