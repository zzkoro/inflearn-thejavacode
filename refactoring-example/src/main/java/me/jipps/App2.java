package me.jipps;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("me.jipps.Book");
        Constructor<?> constructor = bookClass.getConstructor(null);
        Book book = (Book)constructor.newInstance(null);
        System.out.println(book);

        Field a = Book.class.getDeclaredField("A");
        System.out.println(a.get(null));

        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book));
        b.set(book, "BBBBBB");
        System.out.println(b.get(book));

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);

        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int ret = (int)sum.invoke(book, 10, 20);
        System.out.println("ret:" + ret);

    }
}
