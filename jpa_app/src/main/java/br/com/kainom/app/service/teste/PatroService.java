package br.com.kainom.app.service.teste;

import br.com.kainom.app.entity.Prato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PatroService {
    public static void main(String[] args) {
        Prato arrozCaseiro = new Prato();
        arrozCaseiro.setNome("Arroz Caseiro");
        arrozCaseiro.setDescricao("Arroz Caseiro  acompanhado de calabrase com torresmo");
        arrozCaseiro.setDisponivel(true);
        arrozCaseiro.setValor(BigDecimal.valueOf(30.50d));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("appJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(arrozCaseiro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
