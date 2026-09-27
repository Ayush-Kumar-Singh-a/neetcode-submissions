class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            if(tokens[i].equals("+")){
                st.push(st.pop() + st.pop());
            }
            else if(tokens[i].equals("*")){
                st.push(st.pop() * st.pop());
            }
            else if(tokens[i].equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }
            else if(tokens[i].equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
