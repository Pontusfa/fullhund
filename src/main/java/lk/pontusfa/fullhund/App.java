package lk.pontusfa.fullhund;

/**
 * apa
 */
public class App {
    String getGreeting1(boolean a) {
        if(a) {
            return "Hello world1.";
        }
        else {
            return null;
        }
    }

    String getGreeting3(boolean a) {
        if(a) {
            return "Hello world3.";
        }
        else {
            return null;
        }
    }

    String getGreeting4(boolean a) {
        if(a) {
            return "Hello world4.";
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        if(args.length > 0) {
            new App().getGreeting1(true);
        }
        else {
            new App().getGreeting3(false);
        }
    }
}
