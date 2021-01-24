package me.jipps.demospringdi;

public class BookService2 {

    public void rent(Book book) {
        System.out.println("rent: " + book.getTitle());
    }

    public void returnBook(Book book) {
        System.out.println("return: " + book.getTitle());
    }
}
