package app.model;

import org.springframework.stereotype.Component;
@Component("time")
public class Time extends Timer{

    @Override
    public String toString() {
        return getTime().toString();
    }
}
