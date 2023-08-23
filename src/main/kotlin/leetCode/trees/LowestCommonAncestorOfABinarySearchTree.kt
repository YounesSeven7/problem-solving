package leetCode.trees

class LowestCommonAncestorOfABinarySearchTree {
    class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val rootVal = root!!.`val`
        val min = minOf(p!!.`val`, q!!.`val`)
        val max = maxOf(p.`val`, q.`val`)
        return if (rootVal in min..max)
            root
        else if (max < rootVal)
            lowestCommonAncestor(root.left!!, p, q)
        else
            lowestCommonAncestor(root.right!!, p, q)
    }
}