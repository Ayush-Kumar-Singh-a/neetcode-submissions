class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] freq = new int[128];
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int required = t.length();
        int start = 0;
        for(char ch: t.toCharArray()){
            freq[ch]++;
        }
        for(int right = 0; right < s.length(); right++){
            if(freq[s.charAt(right)] > 0){
                required--;
            }
            freq[s.charAt(right)]--;
            while(required == 0){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)] > 0){
                    required++;
                }
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start + minLen);
    }
}
