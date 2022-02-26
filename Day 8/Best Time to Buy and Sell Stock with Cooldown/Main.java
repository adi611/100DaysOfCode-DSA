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

        int buyProfit = -prices[0], sellProfit = 0, cooldownProfit = 0;

        for (int i = 1; i < n; i++) {
            int newBuyProfit = 0, newSellProfit = 0, newCooldownProfit = 0;

            if (cooldownProfit - prices[i] > buyProfit) {
                newBuyProfit = cooldownProfit - prices[i];
            } else {
                newBuyProfit = buyProfit;
            }

            if (buyProfit + prices[i] > sellProfit) {
                newSellProfit = buyProfit + prices[i];
            } else {
                newSellProfit = sellProfit;
            }

            if (sellProfit > cooldownProfit) {
                newCooldownProfit = sellProfit;
            } else {
                newCooldownProfit = cooldownProfit;
            }

            buyProfit = newBuyProfit;
            sellProfit = newSellProfit;
            cooldownProfit = newCooldownProfit;
        }

        System.out.println(sellProfit);
    }

}