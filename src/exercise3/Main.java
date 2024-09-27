package exercise3;
import static exercise3.Java.calculate;

public class Main {
    public static void main(String[] args) {
        int a = calculate(1, 2);
        int b = calculate(1, 2, 3);
        double c = calculate(1.5, 2.5);
        System.out.println("Method 1: " + a);
        System.out.println("Method 2: " + b);
        System.out.println("Method 3: " + c);
    }
}
