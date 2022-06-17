/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if(head == null) {
            return null
        } else {
            var tail = ListNode(head.`val`)
            var current = head.next
            while(current != null) {
                val node = ListNode(current.`val`)
                node.next = tail
                tail = node
                current = current.next
            }
            return tail
        }
    }
}