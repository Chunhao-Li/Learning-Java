package corejava.Chapter6;

import javax.swing.Timer;
public class Greeter {
    public void greet() {
        System.out.println("Hello, world!");
    }

    public static void main(String[] args) {
        Greeter test = new TimedGreeter();
        test.greet();
    }

}

class TimedGreeter extends Greeter {
    public void greet() {
        Timer t = new Timer(1000, e->super.greet());
        t.start();
    }
}
