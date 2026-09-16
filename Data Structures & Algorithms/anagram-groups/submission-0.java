class Solution {
    private boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];
        for(int i = 0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int count: freq){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for(String str: strs){
            boolean placed = false;
            for(List<String> group : result){
                if(isAnagram(group.get(0), str)){
                    group.add(str);
                    placed = true;
                    break;
                }
            }
            if(!placed){
                List<String> group = new ArrayList<>();
                group.add(str);
                result.add(group);
            }
        }
        return result;
    }
}
