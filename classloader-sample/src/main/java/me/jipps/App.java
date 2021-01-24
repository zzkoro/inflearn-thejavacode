package me.jipps;

/**
 * Hello world!
 *
 */
public class App {

    static String name;

    static {
        name = "kumjip";
    }

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        System.out.println(App.class.getClassLoader());
        System.out.println(App.class.getClassLoader().getParent());

        AccountService accountService = ContainerService.getObject(AccountService.class);
        accountService.join();
    }
}
