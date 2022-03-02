class StockSpanner {
    ArrayList<Integer> arr;
    Stack<Integer> st;
    int span;

    public StockSpanner() {
        arr = new ArrayList<>();
        st = new Stack<>();
        st.push(0);
        span = 1;
    }

    public int next(int price) {
        arr.add(price);
        int i = arr.size() - 1;

        while (st.size() > 0 && arr.get(i) >= arr.get(st.peek())) {
            st.pop();
        }

        span = st.size() == 0 ? i + 1 : i - st.peek();
        st.push(i);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */