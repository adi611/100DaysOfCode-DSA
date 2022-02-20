//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());

        while (t > 0) {
            String s = sc.next();

            Solution T = new Solution();
            System.out.println(T.fun(s));

            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int fun(String str) {
        int n = str.length();
        int subsequences[][] = new int[3][n + 1];
        int M = 1000000007;
        for (int stringPos = 1; stringPos <= n; stringPos++) {
            char ch = str.charAt(stringPos - 1);
            if (ch == 'a') {
                subsequences[0][stringPos] = ((2 * subsequences[0][stringPos - 1]) % M + 1) % M;
                subsequences[1][stringPos] = subsequences[1][stringPos - 1];
                subsequences[2][stringPos] = subsequences[2][stringPos - 1];
            } else if (ch == 'b') {
                subsequences[1][stringPos] = ((2 * subsequences[1][stringPos - 1]) % M + subsequences[0][stringPos - 1])
                        % M;
                subsequences[0][stringPos] = subsequences[0][stringPos - 1];
                subsequences[2][stringPos] = subsequences[2][stringPos - 1];
            } else {
                subsequences[2][stringPos] = ((2 * subsequences[2][stringPos - 1]) % M + subsequences[1][stringPos - 1])
                        % M;
                subsequences[0][stringPos] = subsequences[0][stringPos - 1];
                subsequences[1][stringPos] = subsequences[1][stringPos - 1];
            }
        }
        return (subsequences[2][n]);
    }
}