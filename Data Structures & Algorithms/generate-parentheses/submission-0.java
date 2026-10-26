class Solution {
    private void func(int open, int close, int n, StringBuilder sb, ArrayList<String> ans){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            func(open + 1, close, n, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(")");
            func(open, close + 1, n, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        func(0, 0, n, sb, ans);
        return ans;
    }
}
