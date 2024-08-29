package br.com.kainom.app.dao;

import javax.persistence.EntityManager;

public class Cardapio {
    private EntityManager entityManager;


    public Cardapio(EntityManager entityManager){this.entityManager = entityManager;}

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

    public br.com.kainom.app.entity.Cardapio consultar (final Integer id){
        return this.entityManager.find(br.com.kainom.app.entity.Cardapio.class,id);

    }

    public void atualizar(final br.com.kainom.app.entity.Cardapio cardapio){
        this.entityManager.merge(cardapio);

    }

    public void deletar(final br.com.kainom.app.entity.Cardapio cardapio){
        this.entityManager.remove(cardapio);


    }
}
