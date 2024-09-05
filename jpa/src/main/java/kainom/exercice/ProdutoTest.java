package kainom.exercice;

import basic.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Produto produto = new Produto(12122.00,"The dark sword");
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
        emf.close();


    }
}
