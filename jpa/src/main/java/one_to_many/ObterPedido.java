package one_to_many;

import basic.model.Produto;
import infra.Dao;

public class ObterPedido {
    public static void main(String[] args) {
        Dao<Pedido> dao = new Dao<>(Pedido.class);
        Pedido pedido = dao.getById(1L);
        pedido.getItens().stream().map(ItemPedido::getQuantidade).forEach(System.out::println);
        pedido.getItens().stream().map(ItemPedido::getProduto).map(Produto::getNome).forEach(System.out::println);
        dao.close();
    }
}
