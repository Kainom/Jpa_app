package one_to_many;

import basic.model.Produto;
import infra.Dao;

public class NovoPedido {
    public static void main(String[] args) {
        Dao<Object> dao = new Dao<>();
        Produto produto = new Produto(1210D,"Castelvania");
        Pedido pedido = new Pedido();
        ItemPedido item = new ItemPedido(pedido,produto,2);

        dao.openTransaction().include(pedido).include(produto).include(item).closeTransaction().close();
    }
}
