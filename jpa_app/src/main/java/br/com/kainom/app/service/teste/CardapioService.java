package br.com.kainom.app.service.teste;

import br.com.kainom.app.dao.Cardapio;
import br.com.kainom.app.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PatroService {
    public static void main(String[] args) {
        br.com.kainom.app.entity.Cardapio arrozCaseiro = new br.com.kainom.app.entity.Cardapio();
        arrozCaseiro.setNome("Arroz Caseiro");
        arrozCaseiro.setDescricao("Arroz Caseiro  acompanhado de calabrase com torresmo");
        arrozCaseiro.setDisponivel(true);
        arrozCaseiro.setValor(BigDecimal.valueOf(30.50d));

        br.com.kainom.app.entity.Cardapio torresmo = new br.com.kainom.app.entity.Cardapio();
        torresmo.setNome("Torresmo");
        torresmo.setDescricao("Torresmo gostoso de porco carnudo");
        torresmo.setDisponivel(true);
        torresmo.setValor(BigDecimal.valueOf(40.87d));


        EntityManager entityManager = JPAUtil.getEntityManagerAPPjpa();
        Cardapio cardapio = new Cardapio(entityManager);
        entityManager.getTransaction().begin();

        cardapio.cadastrar(arrozCaseiro);
        entityManager.flush();
        cardapio.cadastrar(torresmo);
        entityManager.flush();

        System.out.println("O prato consultado foi " + cardapio.consultar(2));
        cardapio.deletar(torresmo);
        System.out.println("Torresmo: " + cardapio.consultar(2));
        entityManager.clear();
        arrozCaseiro.setNome("Arroz Carreteiro");
        entityManager.flush();
        System.out.println("O prato consultado foi " + cardapio.consultar(1));

//        entityManager.getTransaction().commit();
//        entityManager.close();
    }
}
