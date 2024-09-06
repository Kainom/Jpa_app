package kainom.exercice;

import basic.model.Produto;
import infra.Dao;

public class NovoProduto {

    public static void main(String[] args) {
        Dao<Produto> dao = new Dao<>(Produto.class);
        Produto produto = new Produto(13005d,"Zenpakutou");
        Produto produt2 = new Produto(13005d,"The shield of true");

        dao.openTransaction().include(produto).closeTransaction().close();
//        dao.includeAtomic(produt2).close();
    }

}
