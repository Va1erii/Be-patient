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
    
    fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null) {
            return list2
        } else if(list2 == null) {
            return list1
        } else {
            return if(list1.`val` < list2.`val`) {
                val node = ListNode(list1.`val`)
                node.next = merge(list1.next, list2)
                node
            } else {
                val node = ListNode(list2.`val`)
                node.next = merge(list1, list2.next)
                node
            }
        }
    }
    
    
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return merge(list1, list2)
    }
}