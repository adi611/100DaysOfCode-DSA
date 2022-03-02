class Solution {
    public int largestRectangleArea(int[] a) {
        int n = a.length;
        int rb[] = new int[n];
        rb[n - 1] = n;
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && a[i] <= a[st.peek()]) {
                st.pop();
            }

            rb[i] = st.size() == 0 ? n : st.peek();
            st.push(i);
        }

        int lb[] = new int[n];
        lb[0] = -1;
        st = new Stack<>();
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && a[i] <= a[st.peek()]) {
                st.pop();
            }

            lb[i] = st.size() == 0 ? -1 : st.peek();
            st.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = a[i] * width;

            if (area > maxArea) {
                maxArea = area;
            }
        }
        return (maxArea);
    }
}