package me.jipps.demospringdi;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void di() {
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }
}
