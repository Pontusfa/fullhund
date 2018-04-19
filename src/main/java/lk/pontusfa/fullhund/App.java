package lk.pontusfa.fullhund;

/**
 * apa
 */
public class App {
    String getGreeting1(boolean a) {
        if(a) {
            return "Hello world.";
        }
        else {
            return null;
        }
    }

    String getGreeting2(boolean a) {
        if(a) {
            return "Hello world.";
        }
        else {
            return null;
        }
    }

    String getGreeting3(boolean a) {
        if(a) {
            return "Hello world.";
        }
        else {
            return null;
        }
    }

    String getGreeting4(boolean a) {
        if(a) {
            return "Hello world.";
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
            new App().getGreeting2(false);
        }
    }
}
