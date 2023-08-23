package leetCode.trees

import java.lang.StringBuilder
import java.util.LinkedList

class SerializeAndDeserializeBinaryTree {
    class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun serialize(root: TreeNode? = null): String {
        if (root == null) return ""
        val s = StringBuilder()
        fun recursion(root: TreeNode?) {
            if (root == null) {
                s.append("N,")
                return
            }
            s.append("${root.`val`},")
            recursion(root.left)
            recursion(root.right)
        }
        recursion(root)
        return s.substring(0, s.length - 1)
    }

    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val list = data.split(",")
        var index = 0
        fun recursion(root: TreeNode?): TreeNode? {
            index++
            if (root == null) return null
            val left = if (list[index] != "N") recursion(TreeNode(list[index].toInt())) else recursion(null)
            val right = if (list[index] != "N") recursion(TreeNode(list[index].toInt())) else recursion(null)
            root.left = left
            root.right = right
            return root
        }
        val root = recursion(TreeNode(list[0].toInt()))
        return root
    }
}