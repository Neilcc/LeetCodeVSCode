/*
 * @lc app=leetcode id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>();
        for(int i  = 1 ; i <= n ; i++) {
            StringBuilder add =new StringBuilder();
            if(i % 3 == 0){
                add.append("Fizz");
            }
            if(i % 5 == 0){
                add.append("Buzz");
            }
            if(add.length() == 0){
                add.append(i);
            }
            ret.add(add.toString());
        }
        return ret;
        
    }
}
// @lc code=end

