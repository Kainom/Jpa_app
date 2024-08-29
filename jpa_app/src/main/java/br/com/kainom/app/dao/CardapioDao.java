package br.com.kainom.app.dao;

import br.com.kainom.app.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioDao {
    private EntityManager entityManager;


    public CardapioDao(EntityManager entityManager){this.entityManager = entityManager;}


//    crud ->{
//   c: create,
//   r :read
//   u :update
//   d :delete
//   }
public  void cadastrar(final br.com.kainom.app.entity.Cardapio cardapio){
    this.entityManager.persist(cardapio);
    System.out.println("Entidade cadastrada " + cardapio);
}

    public br.com.kainom.app.entity.Cardapio consultarPorId (final Integer id){
        return this.entityManager.find(br.com.kainom.app.entity.Cardapio.class,id);
    }
    public Cardapio consultarPorNome(final String filtro){
            String jpql = "SELECT c FROM Cardapio c WHERE c.nome = :nome";
            return this.entityManager.createQuery(jpql,Cardapio.class).setParameter(nome,filter).getSingleResult();
   }


    public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        String jpql = "SELECT c FROM Cardapio c  WHERE c.valor = :valor"
                return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor",filtro).getResultList();
    }

    public List<Cardapio> consultarTodos(){
            String jpql  = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(jpql,Cardapio.class).getResultList();

    }


    public void atualizar(final br.com.kainom.app.entity.Cardapio cardapio){
        this.entityManager.merge(cardapio);

    }

    public void deletar(final br.com.kainom.app.entity.Cardapio cardapio){
        this.entityManager.remove(cardapio);


    }
}
