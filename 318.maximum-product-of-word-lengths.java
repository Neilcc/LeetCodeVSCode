/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1)
            return 0;
        int[] hash = new int[words.length];
        int index = 0;
        for (String s : words) {
            int init = 0;
            for (char c : s.toCharArray()) {
                init = init | (1 << (c - 'a'));
            }
            hash[index] = init;
            index++;
        }
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            for (int j = i +1 ; j<words.length ; j++) {
                if ((hash[i] & hash[j]) == 0){
                    int m = words[i].length() * words[j].length();
                    if(m > max){
                        max = m;
                    }
                }
            }
        }
        return max;
    }
}
// @lc code=end
