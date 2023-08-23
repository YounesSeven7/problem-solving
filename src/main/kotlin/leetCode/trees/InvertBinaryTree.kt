package leetCode.trees

class InvertBinaryTree {

    class TreeNode(
        var `val`: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )

    fun invertTree(root: TreeNode?): TreeNode? {
        invert(root)
        return root
    }

    fun invert(root: TreeNode?) {
        if (root == null) return

        val temp = root.left
        root.left = root.right
        root.right = temp

        invertTree(root.left)
        invertTree(root.right)
    }




}