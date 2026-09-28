class Solution {
    private int[] findNSE(int[] heights){
        int n = heights.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }
    private int[] findPSE(int[] heights){
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);
        int n = heights.length;
        int maxi = 0;
        for(int i = 0; i<n; i++){
            maxi = Math.max(maxi, heights[i] * (nse[i] - pse[i] - 1));
        }
        return maxi;
    }
}
