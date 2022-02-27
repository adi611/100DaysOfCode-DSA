import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int prices[] = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }

        int dpLeft[] = new int[n];
        int dpRight[] = new int[n];

        int minPrice = prices[0], maxPrice = prices[n - 1];
        int maxProfitLeft = 0, maxProfitRight = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int profitToday = prices[i] - minPrice;
            if (profitToday > maxProfitLeft) {
                maxProfitLeft = profitToday;
            }

            dpLeft[i] = maxProfitLeft;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
            int profitToday = maxPrice - prices[i];
            if (profitToday > maxProfitRight) {
                maxProfitRight = profitToday;
            }

            dpRight[i] = maxProfitRight;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dpLeft[i] + dpRight[i]);
        }

        System.out.println(ans);
    }

}