package lk.pontusfa.fullhund;

/**
 * apa
 *
 */
public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public void a() {
        System.out.println("ha");
    }

    public static void main(String[] args) {
        var test = "empty";
        System.out.println(test + new App().getGreeting());
    }
}
