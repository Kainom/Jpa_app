package many_to_many;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double nota;
    @Column(name="data_lancamento",nullable = false)
    private Date lancamento;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="ator_movie",
            joinColumns = @JoinColumn(name="movie_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="ator_id",referencedColumnName = "id")
    )
    private List<Ator> atores = new ArrayList<>();

    public Movie() {}
    public Movie(String nome, Double nota, Date lancamento) {
        this.nome = nome;
        this.nota = nota;
        this.lancamento = lancamento;
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
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }
    public Date getLancamento() {
        return lancamento;
    }
    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }
    public List<Ator> getAtores() {
        if(this.atores == null) this.atores = new ArrayList<>();
        return atores;
    }
    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public  void addAtor(Ator ator){
        if(ator != null && !getAtores().contains(ator)) {
            getAtores().add(ator);
        if(!ator.getMovies().contains(this)){
            ator.getMovies().add(this);
        }
        }
    }

}
