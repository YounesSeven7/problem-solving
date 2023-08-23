package leetCode.trees

class SubtreeOfAnotherTree {
    class TreeNode(
        var `val`: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )

    fun isSubtree(
        root: TreeNode? = TreeNode(3,
            TreeNode(4, TreeNode(1), TreeNode(2, TreeNode(0)))
            , TreeNode(5)),
        subRoot: TreeNode? = TreeNode(4, TreeNode(1), TreeNode(2))
    ): Boolean {
        if (root == null) return false
        return isSameTree(root, subRoot)
                || isSubtree(root?.left, subRoot)
                || isSubtree(root?.right, subRoot)
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p?.`val` != q?.`val`) return false
        return isSameTree(p?.right, q?.right) && isSameTree(p?.left, q?.left)
    }
}