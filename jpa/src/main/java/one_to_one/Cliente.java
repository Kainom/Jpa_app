package one_to_one;

import jakarta.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;



    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "assento_id",unique = true)
    private Assento assento;

    public Cliente(){
        super();
    }

    public Cliente(String nome) {
        super();
        this.nome = nome;
    }
    public Cliente(String nome,Assento assento){
        super();
        this.nome = nome;
        this.assento = assento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public Long getId() {
        return id;
    }
}
