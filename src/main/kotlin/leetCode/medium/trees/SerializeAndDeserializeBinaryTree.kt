package leetCode.medium.trees

import java.util.LinkedList

class SerializeAndDeserializeBinaryTree {
    class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun serialize(root: TreeNode? = null): String {
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        var s = ""
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            s += if (node != null) {
                queue.add(node.left)
                queue.add(node.right)
                ",${node.`val`}"
            } else
                ",N"
        }

        s = s.replace(Regex("(,N)*$"), "")
        return if (s.isEmpty()) s else s.substring(1)
    }

    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val list = data.split(",")

        var index = 0

        val root = TreeNode(list[0].toInt())

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (2*index+2 < list.size) {
            val currentTreeNode = queue.removeFirst()

            val leftValue = list[2*index+1]
            if (leftValue != "N") {
                val left = TreeNode(leftValue.toInt())
                queue.add(left)
                currentTreeNode.left = left
            }

            val rightValue =  list[2*index+2]
            if (rightValue != "N") {
                val right =  TreeNode(rightValue.toInt())
                queue.add(right)
                currentTreeNode.right = right
            }

            index++
        }

        if(2*index+1 < list.size) {
            val currentTreeNode = queue.removeFirst()
            val leftValue = list[2*index+1]
            if (leftValue != "N") currentTreeNode.left = TreeNode(leftValue.toInt())
        }

        return root
    }
}