package leetCode

import leetCode.trees.SerializeAndDeserializeBinaryTree
import leetCode.trees.SerializeAndDeserializeBinaryTree.TreeNode

fun main() {
    val input = TreeNode(1,
        TreeNode(2,
            TreeNode(3,
                TreeNode(4)))
    )
    val serializeAndDeserializeBinaryTree = SerializeAndDeserializeBinaryTree()
    val output = serializeAndDeserializeBinaryTree.serialize(input)
    println(output)
    //serializeAndDeserializeBinaryTree.deserialize(output)
    

}

