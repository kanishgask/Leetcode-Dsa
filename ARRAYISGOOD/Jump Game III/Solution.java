import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            
            
            if (arr[idx] == 0) return true;
            
           
            int forward = idx + arr[idx];
            if (forward < n && !visited[forward]) {
                visited[forward] = true;
                queue.offer(forward);
            }
            
          
            int backward = idx - arr[idx];
            if (backward >= 0 && !visited[backward]) {
                visited[backward] = true;
                queue.offer(backward);
            }
        }
        
        return false;
    }
}
