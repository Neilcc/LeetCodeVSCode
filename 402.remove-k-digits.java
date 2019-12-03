/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";
        String in = num;
        while (k > 0) {
            in = rm(in);
            k--;
        }
        if(in.length() ==0) return "0";
        return in;
    }

    private String rm(String num) {
        if(num.length() == 0) return num;
        Integer val = Integer.valueOf(num.charAt(0) + "");
        int pivot = 0;
        for (int i = 1; i < num.length(); i++) {
            Integer cur = Integer.valueOf(num.charAt(i) + "");
            if (cur < val) {
                break;
            } else {
                pivot = i;
                val = cur;
            }
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        int i = 0;
        if (pivot == 0) {
            i++;
        }
        for (; i < num.length(); i++) {
            Integer val2 = Integer.valueOf(num.charAt(i) + "");
            if (leadingZero && val2 == 0) {
                continue;
            } else {
                leadingZero = false;
            }
            if (i != pivot) {
                ret.append(num.charAt(i));
            }
        }
        return ret.toString();
    }
}
// @lc code=end
