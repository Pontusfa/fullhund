package lk.pontusfa.fullhund;

import org.apache.commons.lang3.math.Fraction;

/**
 * apa
 *
 */
public class App {
    public String getGreeting() {
        System.out.println(Fraction.getFraction("1/3"));
        return "Hello world.";
    }

    public void a() {
        System.out.println("ha");
    }

    public static void main(String[] args) {
        String test = "empty";
        System.out.println(test + new App().getGreeting());
    }
}
