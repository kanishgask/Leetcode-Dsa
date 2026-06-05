import java.util.*;

class Solution {

    static class Pair {
        long count;
        long waviness;

        Pair(long c, long w) {
            count = c;
            waviness = w;
        }
    }

    private char[] digits;
    private Pair[][][][][] memo;
    private boolean[][][][][] seen;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;

        digits = Long.toString(n).toCharArray();

        memo = new Pair[17][11][11][4][2];
        seen = new boolean[17][11][11][4][2];

        return dfs(0, true, false, 10, 10, 0).waviness;
    }

    /**
     * pos      -> current index
     * tight    -> digit restriction
     * started  -> number has started (non-leading digit seen)
     * prev2    -> second last digit (0-9), 10 if unavailable
     * prev1    -> last digit (0-9), 10 if unavailable
     * lenState -> 0 = length 0
     *             1 = length 1
     *             2 = length 2
     *             3 = length >= 3
     */
    private Pair dfs(int pos,
                     boolean tight,
                     boolean started,
                     int prev2,
                     int prev1,
                     int lenState) {

        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (!tight) {
            int s = started ? 1 : 0;

            if (seen[pos][prev2][prev1][lenState][s]) {
                return memo[pos][prev2][prev1][lenState][s];
            }
        }

        int limit = tight ? digits[pos] - '0' : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int d = 0; d <= limit; d++) {

            boolean nextTight = tight && (d == limit);

            if (!started && d == 0) {
                Pair nxt = dfs(pos + 1, nextTight, false, 10, 10, 0);

                totalCount += nxt.count;
                totalWaviness += nxt.waviness;
            } else {

                int add = 0;

                if (started && lenState >= 2) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                int nextPrev2;
                int nextPrev1;
                int nextLenState;

                if (!started) {
                    nextPrev2 = 10;
                    nextPrev1 = d;
                    nextLenState = 1;
                } else {
                    nextPrev2 = prev1;
                    nextPrev1 = d;

                    if (lenState == 1) nextLenState = 2;
                    else nextLenState = 3;
                }

                Pair nxt = dfs(
                        pos + 1,
                        nextTight,
                        true,
                        nextPrev2,
                        nextPrev1,
                        nextLenState
                );

                totalCount += nxt.count;
                totalWaviness += nxt.waviness + (long) add * nxt.count;
            }
        }

        Pair ans = new Pair(totalCount, totalWaviness);

        if (!tight) {
            int s = started ? 1 : 0;
            seen[pos][prev2][prev1][lenState][s] = true;
            memo[pos][prev2][prev1][lenState][s] = ans;
        }

        return ans;
    }
}
