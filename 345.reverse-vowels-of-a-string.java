import java.util.Set;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] chars = s.toCharArray();
        char[] ret = new char[chars.length];
        int i = 0;
        int j = chars.length -1;
        while (i < j){
            while(i<j && !vowels.contains(chars[i])){
                ret[i] = chars[i];
                i++;
            }
            while(i <j && !vowels.contains(chars[j])){
                ret[j] = chars[j];
                j--;
            }
            if(i < j ){
                ret[i] = chars[j];
                ret[j] = chars[i];
                i ++;
                j --;
            }
        }
        if(i == j){
            ret[i] = chars[i];
        }
        return new String(ret);
    }
}
// @lc code=end
