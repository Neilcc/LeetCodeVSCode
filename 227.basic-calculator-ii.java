/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
     public  int calculate(String s) {
            if (s == null || s.length() == 0)
            return 0;
        ArrayList<String> words = new ArrayList<>();
        s = s.replace(" ", "");
        char[] sb = s.toCharArray();
        String curNum = "";
        for (char c : sb) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                words.add(curNum);
                words.add(c + "");
                curNum = "";
            } else {
                curNum = curNum + c;
            }
        }
        if (!curNum.isEmpty()) {
            words.add(curNum);
        }
        Deque<String> vals = new LinkedList<>();
        for (int i = 0; i < words.size(); i++) {
            String c = words.get(i);
            if (c.equals("*")) {
                String before = vals.pop();
                i++;
                String next = words.get(i);
                long val = Long.valueOf(before) * Long.valueOf(next + "");
                vals.push(String.valueOf(val));
            } else if (c.equals("/")) {
                String before = vals.pop();
                i++;
                String next = words.get(i);
                long val = Long.valueOf(before) / Long.valueOf(next + "");
                vals.push(String.valueOf(val));
            } else if (c.equals("+") || c.equals("-")) {
                vals.push(c + "");
            } else {
                vals.push(c);
            }
        }

        long val = Long.parseLong(vals.removeLast());
        while (vals.size() > 0) {
            String oper = vals.removeLast();
            long val2 = Long.parseLong(vals.removeLast());
            if ("-".equals(oper)) {
                val -= val2;
            } else {
                val += val2;
            }
        }
        return (int) val;
    }
}
// @lc code=end
