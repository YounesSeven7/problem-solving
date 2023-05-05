package leetCode.medium.trees

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.size == 1) return TreeNode(preorder[0])

        val root = TreeNode(preorder[0])
        var left: TreeNode? = null
        var right: TreeNode? = null

        for (i in inorder.indices) {
            if (preorder[0] == inorder[i]) {
                if (i != 0) {
                    left = buildTree(
                        preorder.copyOfRange(0+1, i+1),
                        inorder.copyOfRange(0, i)
                    )
                }
                if (i != inorder.size-1) {
                    right = buildTree(
                        preorder.copyOfRange(i+1, preorder.size),
                        inorder.copyOfRange(i+1, inorder.size)
                    )
                }
            }
        }
        root.left = left
        root.right = right
        return root
    }



}