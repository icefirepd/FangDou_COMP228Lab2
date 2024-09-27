package exercise2;

import java.util.Random;

public class Lotto {
    //one array instance variable to hold three random integer values
    int[] values = new int[3];
    Random random = new Random();

    //integer values (from 1 to 9).
    public Lotto() {
        for (int i = 0; i < 3; i++) {
            //ensure not 0-9
            values[i] = random.nextInt(9) + 1;
        }
    }
    //Also, include a method in the class to return the array.
    public int[] getValues() {
        return values;
    }
    //and each time the sum of lotto numbers is calculated
    public int eachSum() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += values[i];
        }
        return sum;
    }
}
