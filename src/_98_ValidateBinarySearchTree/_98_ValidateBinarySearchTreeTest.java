package _98_ValidateBinarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _98_ValidateBinarySearchTreeTest {

    @Test
    public void testTree_2_1_3() {
        _98_ValidateBinarySearchTree._98_ValidateBinarySearchTree.TreeNode root = new _98_ValidateBinarySearchTree._98_ValidateBinarySearchTree.TreeNode();
        root.val = 2;
        root.left = new _98_ValidateBinarySearchTree._98_ValidateBinarySearchTree.TreeNode(1, null, null);
        root.right = new _98_ValidateBinarySearchTree._98_ValidateBinarySearchTree.TreeNode(3, null, null);

        _98_ValidateBinarySearchTree validateBinarySearchTree = new _98_ValidateBinarySearchTree();
        boolean actualResult = validateBinarySearchTree.isValidBST(root);

        assertEquals(true, actualResult);
    }
}