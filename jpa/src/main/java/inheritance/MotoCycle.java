package inheritance;

import jakarta.persistence.*;

@Entity
@Table(name="moto_cycle")
public class MotoCycle extends Vehicle{
    private String bag;
    public MotoCycle(Long id, String brand, String model, String bag) {
        super(id, brand, model);
        this.bag = bag;
    }
    public MotoCycle() {

    }
}
