package lk.pontusfa.fullhund;

/**
 * apa
 */
public class App {
    String getGreeting(boolean a) {
        if(a) {
            return "Hello world.";
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        if(args.length > 0) {
            new App().getGreeting(true);
        }
    }
}
