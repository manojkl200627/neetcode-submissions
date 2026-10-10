public class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        res.add("");
        String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "qprs", "tuv", "wxyz"
        };

        for (char digit : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String curStr : res) {
                for (char c : digitToChar[digit - '0'].toCharArray()) {
                    tmp.add(curStr + c);
                }
            }
            res = tmp;
        }
        return res;
    }
}





