class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> st = new Stack<>();
        for(int i = 0; i<n; i++){
            int p = cars[i][0];
            int s = cars[i][1];
            double time = (double)(target - p)/s;
            st.push(time);
            while(st.size() >= 2 && st.peek() <= st.get(st.size() - 2)){
                st.pop();
            }
        }
        return st.size();
    }
}
