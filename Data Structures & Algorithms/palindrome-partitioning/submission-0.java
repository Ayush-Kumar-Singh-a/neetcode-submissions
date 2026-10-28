class Solution {
    private boolean isPalindrome(String s, int start, int last){
        while(start <= last){
            if(s.charAt(start) != s.charAt(last)){
                return false;
            }
            start++;
            last--;
        }
        return true;
    }
    private void func(int index, String s, List<String> path, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i + 1));
                func(i + 1, s, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        func(0, s, path, ans);
        return ans;
    }
}
