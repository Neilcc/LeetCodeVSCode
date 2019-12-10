import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {

    private int tarSize = 0;

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.isEmpty())
            return new ArrayList<>();
        if (tickets.size() == 1)
            return tickets.get(0);
        int tripCount = tickets.size();
        tarSize = tripCount + 1;
        HashMap<String, PriorityQueue<String>> road = new HashMap<>();
        for (List<String> t1 : tickets) {
            PriorityQueue<String> des = road.getOrDefault(t1.get(0), getQ());
            des.add(t1.get(1));
            road.put(t1.get(0), des);
        }
        List<String> ret = new ArrayList<>();
        ret.add("JFK");
        travel(road, ret, "JFK");
        return ret;
    }

    private boolean travel(HashMap<String, PriorityQueue<String>> road, List<String> ret, String node) {
        if (ret.size() == tarSize) {
            return true;
        }
        PriorityQueue<String> curQ = road.get(node);
        if (curQ == null) {
            return false;
        }
        if (curQ.size() > 0) {
            List<String> backStack = new ArrayList<>();
            while (curQ.size() > 0) {
                String next = curQ.poll();
                ret.add(next);
                PriorityQueue<String> newQ = getQ();
                newQ.addAll(backStack);
                newQ.addAll(curQ);
                road.put(node, newQ);
                boolean result = travel(road, ret, next);
                if (result) {
                    return true;
                } else {
                    backStack.add(next);
                    ret.remove(ret.size() - 1);
                }
            }
            curQ.addAll(backStack);
            road.put(node, curQ);
            return false;
        } else {
            return false;
        }

    }

    private PriorityQueue<String> getQ() {
        return new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int ret = a.charAt(0) - b.charAt(0);
                if (ret != 0) {
                    return ret;
                }
                ret = a.charAt(1) - b.charAt(1);
                if (ret != 0) {
                    return ret;
                }
                ret = a.charAt(2) - b.charAt(2);
                return ret;
            }
        });
    }
}
// @lc code=end
