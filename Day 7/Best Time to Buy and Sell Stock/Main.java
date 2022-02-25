import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int price[] = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
        }

        int minPrice = Integer.MAX_VALUE, maxProfit = 0, profitToday;

        for (int i = 0; i < n; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }

            profitToday = price[i] - minPrice;

            if (profitToday > maxProfit) {
                maxProfit = profitToday;
            }
        }
        System.out.println(maxProfit);
    }

}