import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
 
    @Bean(name="hello-world")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }

    @Bean(name="Cat")
    @Scope("prototype")
    public Cat getCat() {
        Cat cat = new Cat();
        cat.setMessage("Cat!");
        return cat;
    }
}