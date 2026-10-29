class Solution {
    private Map<Character, String> digitToChar = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    private void func(int index, String digits, StringBuilder path, List<String> ans){
        if(index == digits.length()){
            ans.add(path.toString());
            return;
        }
        String letters = digitToChar.get(digits.charAt(index));
        for(int i = 0; i< letters.length(); i++){
            path.append(letters.charAt(i));
            func(index + 1, digits, path, ans);
            path.deleteCharAt(path.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        StringBuilder path = new StringBuilder();
        func(0, digits, path, ans);
        return ans;
    }
}
