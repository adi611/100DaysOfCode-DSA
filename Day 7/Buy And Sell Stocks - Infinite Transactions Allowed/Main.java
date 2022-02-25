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

        int buyDay = 0;
        int sellDay = 0;
        int profit = 0;

        for (int i = 1; i < n; i++) {
            if (price[i] >= price[i - 1]) {
                sellDay++;
            } else {
                profit += price[sellDay] - price[buyDay];
                sellDay++;
                buyDay = sellDay;
            }
        }
        profit += price[sellDay] - price[buyDay];
        System.out.println(profit);
    }

}