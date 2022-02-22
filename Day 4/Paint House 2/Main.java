import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int cost[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                cost[i][j] = in.nextInt();
            }
        }
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        int minJ = 0;

        for (int i = 0; i < n; i++) {

            int newMin = Integer.MAX_VALUE;
            int newSecMin = Integer.MAX_VALUE;
            int newMinJ = 0;

            for (int j = 0; j < k; j++) {
                if (i > 0) {
                    if (j == minJ) {
                        cost[i][j] += secMin;
                    } else {
                        cost[i][j] += min;
                    }
                }

                if (cost[i][j] <= newMin) {
                    int temp = newMin;
                    newMin = cost[i][j];
                    newSecMin = temp;

                    newMinJ = j;
                } else if (cost[i][j] < newSecMin) {
                    newSecMin = cost[i][j];
                }
            }

            min = newMin;
            secMin = newSecMin;
            minJ = newMinJ;
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            ans = Math.min(ans, cost[n - 1][j]);
        }

        System.out.println(ans);
    }
}