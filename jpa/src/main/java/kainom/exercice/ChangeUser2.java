package kainom.exercice;

import basic.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ChangeUser2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Product produto = em.find(Product.class,7L);
        produto.setName("Vidas secas");
        produto.setPrice(15000.200);
//        em.merge(produto);
        em.getTransaction().commit();
        em.close();
        emf.close();


    }
}
