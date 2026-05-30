import java.util.*;

class Solution {
    public List<Boolean> getResults(int[][] queries) {
        TreeSet<Integer> obstacles = new TreeSet<>();
        List<Boolean> results = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                // Add obstacle
                obstacles.add(q[1]);
            } else {
                int x = q[1], sz = q[2];
                boolean canPlace = false;

                // Consider interval [0, x]
                int prev = 0;
                for (Integer obs : obstacles.headSet(x + 1)) {
                    // gap = obs - prev
                    if (obs - prev >= sz) {
                        canPlace = true;
                        break;
                    }
                    prev = obs;
                }
                // Last gap: from prev to x
                if (!canPlace && x - prev >= sz) {
                    canPlace = true;
                }

                results.add(canPlace);
            }
        }
        return results;
    }
}
