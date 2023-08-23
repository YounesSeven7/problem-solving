package leetCode.trees

class BinaryTreeRightSideView {
    class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun rightSideView(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        fun recursion(root: TreeNode?) {
            if (root == null) return
            list.add(root.`val`)
            recursion(root.right)
        }
        recursion(root)
        return list
    }
}