package lk.pontusfa.fullhund;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        var test = "empty";
        System.out.println(test + new App().getGreeting());
    }
}
