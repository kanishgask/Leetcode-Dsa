import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int parentVal = d[0], childVal = d[1], isLeft = d[2];

            // Create parent if not exists
            map.putIfAbsent(parentVal, new TreeNode(parentVal));
            // Create child if not exists
            map.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = map.get(parentVal);
            TreeNode child = map.get(childVal);

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        // Root is the one never listed as a child
        for (int[] d : descriptions) {
            int parentVal = d[0];
            if (!children.contains(parentVal)) {
                return map.get(parentVal);
            }
        }
        return null; // should not happen for valid input
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
