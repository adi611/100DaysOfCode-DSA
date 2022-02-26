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
        int fee = in.nextInt();

        int buyProfit = -prices[0];
        int sellProfit = 0;

        for (int i = 1; i < n; i++) {
            int newBuyProfit, newSellProfit;

            newBuyProfit = sellProfit - prices[i];
            if (newBuyProfit < buyProfit) {
                newBuyProfit = buyProfit;
            }

            newSellProfit = buyProfit + prices[i] - fee;
            if (newSellProfit < sellProfit) {
                newSellProfit = sellProfit;
            }

            buyProfit = newBuyProfit;
            sellProfit = newSellProfit;
        }

        System.out.println(sellProfit);
    }

}