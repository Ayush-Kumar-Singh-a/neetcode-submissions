class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[128];
        for(char ch: tasks){
            freq[ch - 'A']++;
        }
        int maxFreq = 0;
        for(int count: freq){
            maxFreq = Math.max(maxFreq, count);
        }
        int maxCount = 0;
        for(int count: freq){
            if(count == maxFreq){
                maxCount++;
            }
        }
        int total = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, total);
    }
}
