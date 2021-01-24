package me.jipps;

@MyOtherAnnotation
public class MyBook extends Book implements MyInterface {
    @Override
    public void printTitle() {
        System.out.println("this book is my book");
    }
}
