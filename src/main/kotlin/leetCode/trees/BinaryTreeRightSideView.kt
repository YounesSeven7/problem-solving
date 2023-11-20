package leetCode.trees

import java.util.LinkedList

class BinaryTreeRightSideView {
    class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun rightSideView(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val queue = LinkedList<TreeNode?>()

        queue.add(root)

        while (queue.isNotEmpty()) {
            var whatWeSee: Int? = null
            repeat(queue.size) {
                val node = queue.pop()
                node?.also {
                    if (whatWeSee == null) whatWeSee = it.`val`
                    queue.add(it.right)
                    queue.add(it.left)
                }
            }
            whatWeSee?.also { list.add(it) }
        }

        return list
    }
}