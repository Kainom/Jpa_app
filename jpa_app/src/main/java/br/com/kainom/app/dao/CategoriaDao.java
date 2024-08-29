package br.com.kainom.app.dao;

import br.com.kainom.app.entity.Cardapio;

import javax.persistence.EntityManager;

public class Categoria {
    private EntityManager entityManager;


    public Categoria(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    public  void cadastrar(Cardapio cardapio){
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultar (Integer id){
       return  this.entityManager.find(Cardapio.class,id);
    }

    public void atualizar(Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void deletar(Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }

}
