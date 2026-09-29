class Solution {
    private int func(int[] piles, int hourly){
        int totalHours = 0;
        for(int i = 0; i<piles.length; i++){
            totalHours += (int)Math.ceil((double) piles[i]/hourly);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; i++){
            if(maxi < piles[i]){
                maxi = piles[i];
            }
        }
        int low = 1;
        int high = maxi;
        int ans = maxi;
        while(low <= high){
            int mid = low + (high - low)/2;
            int hours = func(piles, mid);
            if(hours <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
