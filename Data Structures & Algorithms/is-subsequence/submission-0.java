class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        int p = 0;
        while(j < s.length() && p < t.length()){
            
                if(s.charAt(j)==t.charAt(p)){
                    j++;
                }p++;
        }

        return j==s.length();
    }
}