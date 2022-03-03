class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int ans[] = new int[n - k + 1];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        int nge[] = new int[n];
        nge[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && a[i] >= a[st.peek()]) {
                st.pop();
            }
            nge[i] = st.size() == 0 ? n : st.peek();
            st.push(i);
        }

        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            j = j < i ? i : j;
            while (nge[j] < i + k) {
                j = nge[j];
            }
            ans[i] = a[j];
        }
        return ans;
    }
}