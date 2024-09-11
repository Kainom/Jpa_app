package one_to_many;

import basic.model.Produto;
import jakarta.persistence.*;

@Entity
@Table(name="item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item_pedido",nullable = false,unique = true)
    private  Long id;

    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false)
    private Double preco;


    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
        super();
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }
    public ItemPedido() {
        super();
    }

    public Long getId() {
        return id;
    }


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        if(this.produto !=null && this.getPreco() == null){
            this.setPreco(produto.getPreco());
        }
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
