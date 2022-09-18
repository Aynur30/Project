package app.model;

import org.springframework.stereotype.Component;

@Component("Cat")
public class Cat extends Animal {
    @Override
    public String toString() {
        return "Im a Cat";
    }
}
