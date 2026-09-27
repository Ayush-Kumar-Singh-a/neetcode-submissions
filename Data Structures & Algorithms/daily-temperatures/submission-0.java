class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && temperatures[i] > st.peek()[0]){
                int[] pair = st.pop();
                int temp = pair[0];
                int index = pair[1];
                ans[index] = i - index;
            }
            st.push(new int[]{temperatures[i], i});
        }
        return ans;
    }
}
