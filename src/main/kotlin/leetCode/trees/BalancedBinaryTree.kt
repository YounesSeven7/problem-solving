package leetCode.trees

class BalancedBinaryTree {
    class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun isBalanced(root: TreeNode?): Boolean {
        var isBalanced = true
        fun recursion(root: TreeNode?): Int{
            if (root == null) return 0
            val l = recursion(root.left)
            val r = recursion(root.right)
            val min = minOf(l, r)
            val max = maxOf(l, r)
            if (min != max && min + 1 != max) isBalanced = false
            return max + 1
        }
        recursion(root)
        return isBalanced
    }
}