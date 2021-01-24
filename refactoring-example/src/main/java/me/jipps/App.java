package me.jipps;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class;

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        Class<?> aClass1 = Class.forName("me.jipps.Book");

        Arrays.stream(bookClass.getDeclaredFields()).forEach( f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s : %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("================================================");

        Arrays.stream(bookClass.getDeclaredMethods()).forEach(System.out::println);

        System.out.println("================================================");

        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        System.out.println("================================================");
        System.out.println(MyBook.class.getSuperclass());

        System.out.println("================================================");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        System.out.println("================================================");
        Arrays.stream(book.getClass().getDeclaredAnnotations()).forEach( a -> {
            System.out.println(a);
        });

        System.out.println("================================================");
        Arrays.stream(MyBook.class.getAnnotations()).forEach( a -> {
            System.out.println(a);
            if (a instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) a;

                System.out.println(myAnnotation.id());
                System.out.println(myAnnotation.number());
            }
        });
    }
}
