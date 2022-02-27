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
        int k = in.nextInt();

        int maxProfit[][] = new int[k + 1][n];

        for (int transaction = 1; transaction <= k; transaction++) {
            int max = Integer.MIN_VALUE;
            for (int day = 1; day < n; day++) {
                max = Math.max(max, maxProfit[transaction - 1][day - 1] - prices[day - 1]);
                if (max + prices[day] > maxProfit[transaction][day - 1]) {
                    maxProfit[transaction][day] = max + prices[day];
                } else {
                    maxProfit[transaction][day] = maxProfit[transaction][day - 1];
                }

            }
        }
        System.out.println(maxProfit[k][n - 1]);
    }

}