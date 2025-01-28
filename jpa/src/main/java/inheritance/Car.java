package inheritance;


import jakarta.persistence.*;

@Entity
@Table(name="car")
public class Car extends Vehicle {
    private String color;
    private Integer dors;
    public Car(Long id, String brand, String model, String color,Integer dors) {
        super(id, brand, model);
        this.color = color;
        this.dors = dors;
    }
    public Car() {

    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getDors() {
        return dors;
    }
    public void setDors(Integer dors) {
        this.dors = dors;
    }
}
