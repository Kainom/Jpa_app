package composicao;


import jakarta.persistence.*;

@Entity
@Table(name="fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="fornecedor_id")
    private Long id;
    private Endereco endereco;

    public Fornecedor(Long id, Endereco endereco) {
        this.id = id;
        this.endereco = endereco;
    }
    public Fornecedor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
