package leetCode.trees

import java.util.LinkedList

class BinaryTreeLevelOrderTraversal {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val lists = mutableListOf<List<Int>>()
        if (root == null) return lists

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            var size = queue.size
            val list = mutableListOf<Int>()

            repeat (size) {
                var treeNode = queue.pop()
                list.add(treeNode.`val`)

                if (treeNode.left != null)
                    queue.add(treeNode.left!!)

                if (treeNode.right != null)
                    queue.add(treeNode.right!!)

            }

            lists.add(list)
        }
        return lists
    }
}