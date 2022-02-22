import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int lastTwoSame = k;
        int lastTwoDiff = k * (k - 1);
        int total = lastTwoSame + lastTwoDiff;

        for (int i = 2; i < n; i++) {
            lastTwoSame = lastTwoDiff;
            lastTwoDiff = total * (k - 1);
            total = lastTwoSame + lastTwoDiff;
        }

        System.out.println(total);
    }
}