// Level: Easy
class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val sorted = SortedLinkedList()
        for (i in 0 until nums.size) {
            sorted.add(nums[i] * nums[i])
        }
        return sorted.toArray(nums.size)
    }
}

class SortedLinkedList {
    var root: Node? = null

    fun add(value: Int) {
        if (root == null) {
            root = Node(value, null, null)
        } else {
            var node = root
            while (node != null) {
                if (value < node.value) {
                    val current = Node(value, node.prev, node)
                    node.prev = current
                    node.prev?.prev?.next = current
                    if (node == root) {
                        root = node.prev
                    }
                    break
                } else {
                    if (node.next == null) {
                        node.next = Node(value, node, null)
                        break
                    }
                    node = node.next
                }
            }
        }
    }

    fun toArray(size: Int): IntArray {
        val array = IntArray(size) { -666 }
        var node = root
        var index = 0
        while (node != null) {
            array[index] = node?.value!!
            index += 1
            node = node.next
        }
        return array
    }

    class Node(
        val value: Int,
        var prev: Node?,
        var next: Node?
    )
}
