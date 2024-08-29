package br.com.kainom.app.service.teste;

import br.com.kainom.app.dao.CardapioDao;
import br.com.kainom.app.dao.CategoriaDao;
import br.com.kainom.app.entity.Categoria;
import br.com.kainom.app.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerAPPjpa();
        cadastrarProdutoCardapio(entityManager,cadastrarCategoria(entityManager));

    }

    private static Categoria cadastrarCategoria(EntityManager entityManager){
            CategoriaDao categoriaDao = new CategoriaDao(entityManager);
            Categoria categoria = new Categoria("Prato Especial");
            entityManager.getTransaction().begin();
            categoriaDao.cadastrar(categoria);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return categoria;
    }



    private static  void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria){
        br.com.kainom.app.entity.Cardapio arrozCaseiro = new br.com.kainom.app.entity.Cardapio();
        arrozCaseiro.setNome("Arroz Caseiro");
        arrozCaseiro.setDescricao("Arroz Caseiro  acompanhado de calabrase com torresmo");
        arrozCaseiro.setCategoria(categoria);
        arrozCaseiro.setDisponivel(true);
        arrozCaseiro.setValor(BigDecimal.valueOf(30.50d));

        br.com.kainom.app.entity.Cardapio torresmo = new br.com.kainom.app.entity.Cardapio();
        torresmo.setNome("Torresmo");
        torresmo.setCategoria(categoria);
        torresmo.setDescricao("Torresmo gostoso de porco carnudo");
        torresmo.setDisponivel(true);
        torresmo.setValor(BigDecimal.valueOf(40.87d));


        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(arrozCaseiro);
        entityManager.flush();
        cardapioDao.cadastrar(torresmo);
        entityManager.flush();

        System.out.printf( "" + cardapioDao.consultarPorId(1));
        cardapioDao.consultarTodos().forEach(elementon -> System.out.println(elementon));
        entityManager.close();
    }


}


