import java.util.Set;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
       String[] words = str.split(" ");
       if(pattern.length() != words.length) return false;
       Map<Character, String> map = new HashMap<>();
       Set<String> recorded = new HashSet<>();
       for(int i = 0; i < words.length; i++){
            char c = pattern.charAt(i);   
            String record = map.get(c);
            if(record == null){
                if(recorded.contains(words[i])){
                    return false;
                }
                map.put(c, words[i]);
                recorded.add(words[i]);
            }else{
                String w = words[i];
                if(!record.equals(w)){
                    return false;
                }
            }
       }
       return true;
    }
}
// @lc code=end

