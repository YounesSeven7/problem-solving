package leetCode.trees

class CountGoodNodesInBinaryTree {
    class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 1
        var count = 0
        fun recursion(root: TreeNode?, maxValue: Int) {
            if (root == null) return
            var maxValue = if (root.`val` >= maxValue) {
                count++
                root.`val`
            } else maxValue
            recursion(root.left, maxValue)
            recursion(root.right, maxValue)
        }
        recursion(root, Int.MIN_VALUE)
        return count
    }
}