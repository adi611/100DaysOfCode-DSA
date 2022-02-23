import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int ways[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i < m) {
                ways[i] = 1;
            } else if (i == m) {
                ways[i] = 2;
            } else {
                ways[i] = ways[i - 1] + ways[i - m];
            }
        }

        System.out.println(ways[n]);
    }
}