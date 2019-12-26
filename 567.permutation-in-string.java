/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] hash1 = new int[26];
        for (int i = 0; i < 26; i++) {
            hash1[i] = 0;
        }
        for (char c : s1.toCharArray()) {
            hash1[c - 'a'] = hash1[c - 'a'] + 1;
        }
        char[] c2 = s2.toCharArray();
        int i = 0;
        int j = s1.length();
        int[] hash2 = new int[26];
        for (int k = 0; k < j; k++) {
            hash2[c2[k] - 'a'] = hash2[c2[k] - 'a'] + 1;
        }
        boolean ret = check(hash1, hash2);
        if (ret)
            return true;
        i++;
        j++;
        while (j <= s2.length()) {
            hash2[c2[i - 1] - 'a'] = hash2[c2[i - 1] - 'a'] - 1;
            hash2[c2[j - 1] - 'a'] = hash2[c2[j - 1] - 'a'] + 1;
            ret = check(hash1, hash2);
            if (ret) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
