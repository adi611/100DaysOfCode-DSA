import java.io.*;
import java.util.*;

public class Main {

    public static class House {
        int red, blue, green;

        public House(int red, int blue, int green) {
            this.red = red;
            this.blue = blue;
            this.green = green;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        House houses[] = new House[n];

        for (int i = 0; i < n; i++) {
            int red = in.nextInt();
            int blue = in.nextInt();
            int green = in.nextInt();

            houses[i] = new House(red, blue, green);
        }

        int incRed = houses[0].red;
        int incBlue = houses[0].blue;
        int incGreen = houses[0].green;

        for (int i = 1; i < n; i++) {
            int newIncRed = houses[i].red + Math.min(incBlue, incGreen);
            int newIncBlue = houses[i].blue + Math.min(incRed, incGreen);
            int newIncGreen = houses[i].green + Math.min(incBlue, incRed);

            incRed = newIncRed;
            incBlue = newIncBlue;
            incGreen = newIncGreen;
        }

        System.out.println(Math.min(incRed, Math.min(incBlue, incGreen)));
    }
}