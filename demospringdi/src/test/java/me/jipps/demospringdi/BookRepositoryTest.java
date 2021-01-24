package me.jipps.demospringdi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void di() {
        assertNotNull(bookRepository);

        Book book = new Book();
        book.setTitle("spring");
        bookRepository.save(book);
        bookRepository.findAll();
    }


}