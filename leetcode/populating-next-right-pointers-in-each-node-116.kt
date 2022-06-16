/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        if(root != null) {
            val nodes = HashMap<Int, Node?>()
            connect(root, nodes, 0)
            return root
        }
        return null
    }
    
    fun connect(node: Node?, nodes: HashMap<Int, Node?>, depth: Int) {
        if(node != null) {
            nodes[depth]?.next = node
            nodes[depth] = node
            connect(node.left, nodes, depth + 1)
            connect(node.right, nodes, depth + 1)
        }
    }
}