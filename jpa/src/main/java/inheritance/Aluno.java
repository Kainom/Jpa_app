package inheritance;

import jakarta.persistence.*;

@Entity
@Table(name="aluno")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo",discriminatorType = DiscriminatorType.STRING)
public class Aluno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id_aluno")
    private Long id;

    private String nome;
    private Double media;

    public Aluno(Long id, String nome, Double media) {

    }
    public Aluno(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}
