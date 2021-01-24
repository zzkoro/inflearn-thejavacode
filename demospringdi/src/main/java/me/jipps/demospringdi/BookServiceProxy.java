package me.jipps.demospringdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BookServiceProxy implements  BookService {

    @Autowired @Qualifier("defaultBookService")
    BookService bookService;

    @Override
    public void rent(Book book) {
        System.out.println("aaaaaa");
        bookService.rent(book);
        System.out.println("bbbbbb");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("aaaaaa");
        bookService.returnBook(book);
        System.out.println("bbbbbb");
    }
}
