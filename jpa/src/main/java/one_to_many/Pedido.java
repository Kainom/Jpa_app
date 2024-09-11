package one_to_many;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido",nullable = false,unique = true)
    private Long id;

    @Column(nullable=false)
    private Date data;

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
}
