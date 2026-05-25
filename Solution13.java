import java.util.*;

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        
        int prefix = 0; // sliding window count of reachable indices
        for (int i = 1; i < n; i++) {
            // Add index that enters window
            if (i - minJump >= 0 && reachable[i - minJump]) {
                prefix++;
            }
            // Remove index that leaves window
            if (i - maxJump - 1 >= 0 && reachable[i - maxJump - 1]) {
                prefix--;
            }
            // Mark reachable if s[i] == '0' and prefix > 0
            reachable[i] = (s.charAt(i) == '0' && prefix > 0);
        }
        
        return reachable[n - 1];
    }
}
