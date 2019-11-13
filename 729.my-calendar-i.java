import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
class MyCalendar {

    ArrayList<int[]> dates = new ArrayList<int[]>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (dates.size() == 0) {
            dates.add(new int[] { start, end });
            return true;
        }
        for (int i = 0; i < dates.size(); i++) {
            if (end <= dates.get(i)[0]) {
                dates.add(i, new int[] { start, end });
                return true;
            } else if (start >= dates.get(i)[1]) {
                continue;
            } else {
                return false;
            }
        }
        dates.add(new int[] { start, end });
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such: MyCalendar
 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
 */
// @lc code=end
