/**
 * Level: Medium
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var size = 0
        val nodes = NodeWrapper(head)
        var current = head
        var currentNode = nodes
        while (current != null) {
            if (current?.next != null) {
                val prev = currentNode
                val next = NodeWrapper(current?.next)
                currentNode.next = next
                currentNode = next
                currentNode.prev = prev
            }
            current = current?.next
            size++
        }
        var node: NodeWrapper? = currentNode
        var index = n
        while (--index > 0) {
            node = node?.prev
        }
        if (node?.current == head) {
            return head?.next
        }
        node?.prev?.current?.next = node?.next?.current
        return head
    }
}

class NodeWrapper(val current: ListNode?) {
    var prev: NodeWrapper? = null
    var next: NodeWrapper? = null
}
