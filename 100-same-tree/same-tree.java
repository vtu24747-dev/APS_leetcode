class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if both are null → same
        if (p == null && q == null) return true;
        
        // if one is null or values differ → not same
        if (p == null || q == null || p.val != q.val) return false;
        
        // check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}