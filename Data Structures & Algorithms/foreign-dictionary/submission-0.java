class Solution {
    public String foreignDictionary(String[] words) {
      boolean[] present = new boolean[26];
      int k = 0;
      for(String word: words){
        for(char ch: word.toCharArray()){
            if(!present[ch - 'a']){
                present[ch - 'a'] = true;
                k++;
            }
        }
      }
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i = 0; i<26; i++){
        adj.add(new ArrayList<>());
      }
      int[] indegree = new int[26];
      for(int i = 0; i<words.length - 1; i++){
        String s1 = words[i];
        String s2 = words[i + 1];
        int len = Math.min(s1.length(), s2.length());
        boolean found = false;
        for(int j = 0; j< len; j++){
            if(s1.charAt(j) != s2.charAt(j)){
                int u = s1.charAt(j) - 'a';
                int v = s2.charAt(j) - 'a';
                adj.get(u).add(v);
                indegree[v]++;
                found = true;
                break;
            }
        }
        if(!found && s1.length() > s2.length()){
            return "";
        }
      }
      Queue<Integer> q = new LinkedList<>();
      for(int i = 0; i<26; i++){
        if(present[i] && indegree[i] == 0){
            q.add(i);
        }
      }
      StringBuilder sb = new StringBuilder();
      int count = 0;
      while(!q.isEmpty()){
        int node = q.poll();
        sb.append((char)(node + 'a'));
        count++;
        for(int it: adj.get(node)){
            indegree[it]--;
            if(indegree[it] == 0){
                q.add(it);
            }
        }
      }
      if(count != k){
        return "";
      }
      return sb.toString();
    }
}
