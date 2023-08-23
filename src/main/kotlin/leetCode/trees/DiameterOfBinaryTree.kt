package leetCode.trees

class DiameterOfBinaryTree {
    class TreeNode(var `val`: Int,
                   var left: TreeNode? = null,
                   var right: TreeNode? = null)

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0
        var maxDiameter = 0
        fun recursion(root: TreeNode?): Int {
            if (root == null) return 0
            val left = recursion(root.left)
            val right = recursion(root.right)
            maxDiameter = maxOf(maxDiameter, left + right)
            return maxOf(left, right) + 1
        }
        recursion(root)
        return maxDiameter
    }


}