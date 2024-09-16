package one_to_many;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido",nullable = false,unique = true)
    private Long id;

    @Column(nullable=false)
    private Date data;

    @OneToMany(mappedBy = "pedido" )
    private List<ItemPedido> itens;

    public Pedido() {
        this(new Date());
    }

    public Pedido(Date data) {
        super();
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
