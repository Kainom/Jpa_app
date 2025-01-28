package inheritance;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Bolsista")
public class AlunoBolsista extends Aluno {

    private Double bolsa;
    public AlunoBolsista(Long id, String nome, Double media, Double bolsa) {
        super(id, nome, media);
        this.bolsa = bolsa;
    }

    public AlunoBolsista(){

    }

    public Double getBolsa() {
        return bolsa;
    }

    public void setBolsa(Double bolsa) {
        this.bolsa = bolsa;
    }
}
