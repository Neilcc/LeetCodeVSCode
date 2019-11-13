import java.util.Set;

/*
 * @lc app=leetcode id=500 lang=java
 *
 * [500] Keyboard Row
 */

// @lc code=start
class Solution {
    public String[] findWords(String[] words) {
        Set<Character> s1 = new HashSet<Character>();
        s1.add('A');
        s1.add('S');
        s1.add('D');
        s1.add('F');
        s1.add('G');
        s1.add('H');
        s1.add('J');
        s1.add('K');
        s1.add('L');
        s1.add('a');
        Set<Character> s2 = new HashSet<Character>();
        s2.add('Q');
        s2.add('W');
        s2.add('E');
        s2.add('R');
        s2.add('T');
        s2.add('Y');
        s2.add('U');
        s2.add('I');
        s2.add('O');
        s2.add('P');
        Set<Character> s3 = new HashSet<Character>();
        s3.add('Z');
        s3.add('X');
        s3.add('C');
        s3.add('V');
        s3.add('B');
        s3.add('N');
        s3.add('M');
        List<String> ret = new ArrayList<>();
        for (String w : words) {
            String ww = w.toUpperCase();
            int last = 0;
            boolean valid = true;
            for (char c : ww.toCharArray()) {
                int cur = 0;
                if (s1.contains(c)) {
                    cur = 1;
                } else if (s2.contains(c)) {
                    cur = 2;
                } else if (s3.contains(c)) {
                    cur = 3;
                }
                if (last == 0) {
                    last = cur;
                }else if (last != cur){
                    valid = false;
                    break;
                }
            }
            if(valid){
                ret.add(w);
            }
        }
        String[]  r = new String[ret.size()];
        for(int i = 0; i < ret.size(); i++){
            r[i] = ret.get(i);
        }
        return r;
    }
}
// @lc code=end
