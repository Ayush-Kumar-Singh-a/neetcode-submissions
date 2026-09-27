class MinStack {
    Stack<Long> st;
    long mini;
    public MinStack() {
        st = new Stack<>();

    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push((long) val);
            mini = val;
        }
        else if(val < mini){
            st.push(2L * val - mini);
            mini = val;
        }
        else{
            st.push((long) val);
        }
    }
    
    public void pop() {
        long top = st.pop();
        if(top < mini){
            mini = (2L * mini - top);
        }
    }
    
    public int top() {
        long top = st.peek();
        return top < mini ? (int) mini : (int) top;
    }
    
    public int getMin() {
        return (int) mini;
    }
}
