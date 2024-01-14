package _98_ValidateBinarySearchTree;
// https://leetcode.com/problems/validate-binary-search-tree/

/*
Notes:
- Don't need to check if children exists. Check if current node is null. Don't do children's homework! Just check yourself (current node)
- The parameter list should contain state values that change every time you move to a node. The values that change as you make the call going down the tree.
- No caching is needed for this problem because we don't go to a node more than once. To know, ask "Will I traverse the tree more than once?"
- "Tell my parent that I'm null and that I'm valid"
- For null nodes, we ask: If nothing exists, what is the default? Is it valid or not valid?
    - If we default null to not return valid, we will always return a false tree! So we default to null as valid.
- If current node is not null and not out of bounds, we recurse.
- Formula (makes more sense if you draw it out):
    - Left subtree parameters:  (left subtree root node, lower bound, currentNode.val)
    - Right subtree parameters: (right subtree root node, currentNode.val, upper bound)
 */

public class _98_ValidateBinarySearchTree {

    public static class TreeNode {  // Given in the question
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isValidBSTRecursive(TreeNode currentNode, long leftBound, long rightBound) {  // state of recursive step

        // Base case 1: Check if current node is null.
        if (currentNode == null) {
            return true;
        }

        // Base case 2: Check if current node is not in bounds
        // or !(leftBound < currentNode.val && currentNode.val < rightBound)
        if (leftBound >= currentNode.val || currentNode.val >= rightBound) {
            return false;
        }

        boolean isValidLeftSubtree = isValidBSTRecursive(currentNode.left, leftBound, currentNode.val);
        boolean isValidRightSubtree = isValidBSTRecursive(currentNode.right, currentNode.val, rightBound);

        return isValidLeftSubtree && isValidRightSubtree;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);  // We don't have a bound at first. Using Long (instead of Integer) to handle edge case.
    }

    public static void main(String[] args) {
        // Input: root = [2,1,3]
        /*
                  2
               /     \
             1        3
            / \      / \
         null null null null

          // Will return true
        */

//        _98_ValidateBinarySearchTree._98_ValidateBinarySearchTree.TreeNode root = new _98_ValidateBinarySearchTree._98_ValidateBinarySearchTree.TreeNode();
//        root.val = 2;
//        root.left = new _98_ValidateBinarySearchTree._98_ValidateBinarySearchTree.TreeNode(1, null, null);
//        root.right = new _98_ValidateBinarySearchTree._98_ValidateBinarySearchTree.TreeNode(3, null, null);


        // Input: root = [5,1,4,null,null,3,6]
        /*
                  5
               /     \
             1         4
            / \      /    \
         null null  3      6
                   / \    / \
               null null null null

          // Will return true
        */

//        _98_ValidateBinarySearchTree.TreeNode root = new _98_ValidateBinarySearchTree.TreeNode();
//        root.val = 5;
//        root.left = new _98_ValidateBinarySearchTree.TreeNode(1, null, null);
//        root.right = new _98_ValidateBinarySearchTree.TreeNode(4, new _98_ValidateBinarySearchTree.TreeNode(3, null, null), new _98_ValidateBinarySearchTree.TreeNode(6, null, null));


        // Input: root = [5,3,null,null,7]
        /*
                5
              /   \
             3    null
            /  \
          null  7
               / \
            null null

          // Will return false because 7 is more than 5 (5 is the upper bound at node 7)
        */
        _98_ValidateBinarySearchTree.TreeNode root = new _98_ValidateBinarySearchTree.TreeNode();
        root.val = 5;
        root.left = new _98_ValidateBinarySearchTree.TreeNode(3, null, new _98_ValidateBinarySearchTree.TreeNode(7, null, null));

        // Run the algorithm with the created tree
        _98_ValidateBinarySearchTree _98_ValidateBinarySearchTree = new _98_ValidateBinarySearchTree();
        System.out.println(_98_ValidateBinarySearchTree.isValidBST(root));
    }
}

