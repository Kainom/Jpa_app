package br.com.kainom.app.entity;

import javax.persistence.*;

@Entity
@Table(name="categorias")
public class Categoria {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String nome ;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
}

@Override
public String toString() {
    return "Categoria{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            '}';
}
