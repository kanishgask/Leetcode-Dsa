//Minimum Initial Energy to Finish Tasks

import java.util.*;

class Solution {
    public int minimumEffort(int[][] tasks) {
      
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int totalEnergy = 0;   
        int requiredEnergy = 0; 

        for (int[] task : tasks) {
            totalEnergy += task[0]; 
            requiredEnergy = Math.max(requiredEnergy, totalEnergy + task[1] - task[0]);
        }

        return requiredEnergy;
    }
}
