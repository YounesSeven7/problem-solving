package leetCode.medium.trees

class BinaryTreeMaximumPathSum {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun maxPathSum(root: TreeNode?): Int {
        var max = Int.MIN_VALUE
        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0

            var left = dfs(root.left)
            var right = dfs(root.right)

            if (left < 0) left = 0
            if (right < 0) right = 0

            max = Math.max(max, left + root.`val` + right)
            
            return Math.max(left + root.`val`, root.`val` + right)
        }
        return dfs(root)
    }
}