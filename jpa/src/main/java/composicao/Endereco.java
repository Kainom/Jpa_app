package composicao;


import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String lograouro;
    private String complemento;

    public Endereco(String lograouro, String complemento) {
        this.lograouro = lograouro;
        this.complemento = complemento;
    }
    public Endereco() {

    }

    public String getLograouro() {
        return lograouro;
    }

    public void setLograouro(String lograouro) {
        this.lograouro = lograouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
