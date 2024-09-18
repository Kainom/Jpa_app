package many_to_many;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sobrinho")
public class Sobrinho {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private int idade;

    @ManyToMany(mappedBy = "sobrinhos",fetch = FetchType.LAZY)
    List<Tio> tios  = new ArrayList<>();

    public Sobrinho(String nome, String sobrenome,int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Sobrinho() {

    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Tio> getTios() {
        return tios;
    }

    public void setTios(List<Tio> tios) {
        this.tios = tios;
    }
}
