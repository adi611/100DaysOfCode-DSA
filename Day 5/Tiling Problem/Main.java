import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // row 1 stores tiles ending with width 1 for that n
        // row 2 represents tiles ending with width 2 for that n
        // row 3 represnets total way of tiling for that n
        int ways[][] = new int[3][n];

        ways[0][0] = 1;
        ways[1][0] = 0;
        ways[2][0] = ways[0][0] + ways[1][0];

        ways[0][1] = 1;
        ways[1][1] = 1;
        ways[2][1] = ways[0][1] + ways[1][1];

        for (int i = 2; i < n; i++) {
            ways[0][i] = ways[1][i - 1] + ways[2][i - 2];
            ways[1][i] = ways[2][i - 2];
            ways[2][i] = ways[0][i] + ways[1][i];
        }

        System.out.println(ways[2][n - 1]);
    }
}