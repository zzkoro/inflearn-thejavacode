package me.jipps;

@MyAnnotation(id = "Book")
public class Book {

    public static String A = "A";

    private String B = "B";

    public void c() {
        System.out.println("C");
    }

    public int sum(int left, int right) {
        return (left + right);
    }
}
