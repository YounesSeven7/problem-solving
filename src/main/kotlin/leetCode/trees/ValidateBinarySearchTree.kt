package leetCode.trees

class ValidateBinarySearchTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return  isValid(root, null, null)
    }

    fun isValid(root: TreeNode?, minValue: Int?, maxValue: Int?): Boolean {
        if (root == null) return true
        if (minValue != null && root.`val` <= minValue ||
            maxValue != null && root.`val` >= maxValue
        ) return false
        return isValid(root.left, minValue, root.`val`) && isValid(root.right, root.`val`, maxValue)
    }


}