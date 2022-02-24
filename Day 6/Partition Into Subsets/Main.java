import java.io.*;
import java.util.*;

public class Main {

    public static long partitionKSubset(int n, int k) {
        long ways[][] = new long[k + 1][n + 1];

        for (int teams = 1; teams <= k; teams++) {
            for (int el = 1; el <= n; el++) {
                if (teams == el) {
                    ways[teams][el] = 1;
                } else if (teams > el) {
                    ways[teams][el] = 0;
                } else if (teams == 1) {
                    ways[teams][el] = 1;
                } else {
                    ways[teams][el] = ways[teams - 1][el - 1] + teams * ways[teams][el - 1];
                }
            }
        }

        return (ways[k][n]);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}