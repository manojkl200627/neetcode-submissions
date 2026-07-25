class Solution {
    public int appendCharacters(String s, String t) {
        int i=0,j=0,count = 0 , spa = 0;
        boolean tu =true;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i)==t.charAt(j)){
                j++;
                spa++;
            }
            i++;
        }
        count = t.length() - spa;
        return count;
    }
}