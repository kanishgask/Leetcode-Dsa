import java.util.*;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Sort asteroids so we always face the smallest first
        Arrays.sort(asteroids);

        long planetMass = mass; // use long to avoid overflow

        for (int asteroid : asteroids) {
            if (planetMass < asteroid) {
                return false; // planet destroyed
            }
            planetMass += asteroid; // absorb asteroid
        }
        return true; // all asteroids destroyed
    }
}
