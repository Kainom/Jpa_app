package one_to_one;

import jakarta.persistence.*;

@Entity
@Table(name="assento")
public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String local;

    @OneToOne(mappedBy = "assento")
    private Cliente cliente;

    public Assento(){
        super();
    }

    public Assento(String local ) {
        super();
        this.local = local;
    }

    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Long getId() {
        return id;
    }


}
