import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int ways[] = new int[n + 1];

        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + (i - 1) * ways[i - 2];
        }

        System.out.println(ways[n]);
    }

}