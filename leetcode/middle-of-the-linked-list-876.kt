/**
 * Level: Easy
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var size = 0
        var current = head
        var result = NodeWrapper(current)
        while (current != null) {
            current = current?.next
            size += 1
            if (current != null) {
                val prev = result
                result = NodeWrapper(current)
                result.prev = prev
            }
        }
        var mid = size / 2 + 1
        var i = size
        var currentRes: NodeWrapper? = result
        while (i > mid) {
            currentRes = currentRes?.prev
            i--
        }
        return currentRes?.tail
    }
}

class NodeWrapper(val tail: ListNode?) {
    var prev: NodeWrapper? = null
}
