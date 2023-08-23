package leetCode.trees

class KthSmallestElementInABST {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var smallest = 1
        var stack = ArrayDeque<TreeNode>()
        var node = root
        while (true) {
            if (node != null) {
                stack.add(node)
                node = node.left
            } else {
                val tree = stack.removeLast()
                if (smallest == k) return tree.`val`
                node = tree.right
                smallest++
            }
        }
    }


}