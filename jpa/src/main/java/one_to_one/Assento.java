package one_to_one;

import jakarta.persistence.*;

@Entity
@Table(name="assento")
public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String local;

    public Assento(){
        super();
    }

    public Assento(String local ) {
        super();
        this.local = local;
    }
}
