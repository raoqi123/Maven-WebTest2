package rq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by raoqi on 16/9/25.
 */
@Component("book")
public class Book {
    @Value("葵花宝典")
    private String name;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
