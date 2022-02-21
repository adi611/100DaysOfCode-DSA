class Solution {
    public int rob(int[] el) {
        int n = el.length;
        int inc = el[0];
        int exc = 0;

        for (int i = 1; i < n; i++) {
            int temp = inc;
            inc = exc + el[i];
            exc = Math.max(temp, exc);
        }
        int max = Math.max(inc, exc);
        return (max);
    }
}