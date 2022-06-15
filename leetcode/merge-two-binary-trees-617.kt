/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * Lelel: Easy
 */
class Solution {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if(root1 == null) return root2
        if(root2 == null) return root1
        return sumTrees(root1!!, root2!!)
    }
    
    fun sumTrees(root1: TreeNode?, root2: TreeNode?): TreeNode?{
        val value = if(root1 != null && root2 != null) {
            root1.`val` + root2.`val`
        } else if(root1 != null) {
            root1.`val`
        } else if(root2 != null){
            root2.`val`
        } else {
            null
        }
        if(value != null) {
            val node = TreeNode(value)
            if(root1?.left != null || root2?.left != null) {
                node.left = sumTrees(root1?.left, root2?.left)
            }
            if(root1?.right != null || root2?.right != null) {
                node.right = sumTrees(root1?.right, root2?.right)
            }
            return node
        }
        return null
    }
}