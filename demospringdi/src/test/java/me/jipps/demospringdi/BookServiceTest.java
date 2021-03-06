package me.jipps.demospringdi;


import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.stream.Stream;

import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@SpringBootTest
public class BookServiceTest {

    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}, new InvocationHandler() {

        BookService bookService = new DefaultBookService();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.getName().equals("rent")) {
                System.out.println("aaaa");
                Object invokeResult = method.invoke(bookService, args);
                System.out.println("bbbb");
                return invokeResult;
            }
            return method.invoke(bookService, args);
        }
    });


    @Test
    public void di() throws InvocationTargetException, IllegalAccessException {
        Book book = new Book();
        book.setTitle("spring");

        List<Method> methodList = List.of(BookService.class.getDeclaredMethods());
        System.out.println("bookService class info: " + bookService.getClass());
        Stream.of(bookService.getClass().getDeclaredMethods()).forEach( m -> {
            System.out.println("bookService Proxy method: " + m.getName() + ", returnType: " + m.getReturnType());
            System.out.println("parameters:");
            Stream.of(m.getParameterTypes()).forEach(System.out::println);
            System.out.println("-----------------------------");
        });

        for (Method method : methodList) {
            System.out.println("method name: " + method.getName());
            method.invoke(bookService, book);
        }

//        bookService.rent(book);
//        bookService.returnBook(book);
    }

    @Test
    public void di2() {

        MethodInterceptor handler = new MethodInterceptor() {
            BookService2 bookService2 = new BookService2();
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("aaaaaa");
                Object invokeRet = method.invoke(bookService2, objects);
                System.out.println("bbbbbb");
                return invokeRet;
            }
        };

        BookService2 bookService2 = (BookService2) Enhancer.create(BookService2.class, handler);

        Book book = new Book();
        book.setTitle("spring");
        bookService2.rent(book);
        bookService2.returnBook(book);
    }

    @Test
    public void di3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends BookService2> proxyClass = new ByteBuddy().subclass(BookService2.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    BookService2 bookService2 = new BookService2();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("aaaa");
                        System.out.println("proxy:" + proxy);
                        Object invoke = method.invoke(bookService2, args);
                        System.out.println("bbbb");
                        return invoke;
                    }
                }))
                .make()
                .load(BookService2.class.getClassLoader())
                .getLoaded();
        BookService2 bookService2 = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setTitle("spring");
        bookService2.rent(book);
        bookService2.returnBook(book);
    }

    @Test
    public void di4() {
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        Book hibernateBook = new Book();
        when(bookRepositoryMock.save(any())).thenReturn(hibernateBook);
    }
}
