import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */
class Solution {
    public int numIslands(char[][] grid) {
       if(grid.length == 0 || grid[0].length == 0) return 0;
       int count = 0;
       int m  = grid.length;
       int n = grid[0].length;
       Set<Integer> searched = new HashSet<>(); 
       for(int i = 0 ; i < grid.length; i ++){
            for(int j = 0 ; j < grid[0].length ; j ++){
                if(grid[i][j] == '0' || searched.contains(i * n + j)) continue;
                count ++;
                bfs(searched, i , j ,grid);
            }
       }
       return count;
    }

    private void bfs (Set<Integer> searched, int i, int j , char[][] grid){
        Queue<Integer> next = new LinkedList<>();
        int m  = grid.length;
        int n = grid[0].length;
        next.add(i * n +j);
        while(next.size() != 0){
            int t = next.poll();
            if(searched.contains(t)) continue;
            searched.add(t);
            int ii = t / n;
            int jj = t % n;
            if(ii + 1 <m && grid[ii+1][jj] == '1'){
                next.add((ii+1) * n + jj);
            }
            if(jj + 1 <n && grid[ii][jj+1] == '1'){
                next.add(ii * n + jj +1);
            }
            if(ii - 1 >=0 && grid[ii-1][jj] == '1'){
                next.add((ii-1) * n +jj);
            }            
            if(jj -1 >=0 && grid[ii][jj-1] == '1'){
                next.add(ii * n + jj -1);
            }
        }
    }
}

