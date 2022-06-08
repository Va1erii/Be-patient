// Level: Medium
class Solution {
    fun rotate(nums: IntArray, k: Int) {
        val result = IntArray(nums.size) { -666 }
        for(i in 0 until nums.size) {
            val index = findIndex(nums.size, i, k)
            result[index] = nums[i]
        }
        for(i in 0 until nums.size) {
            nums[i] =  result[i]
        }
    }

    fun findIndex(size: Int, current: Int, step: Int): Int {
        var index = (current + step) % size
        return index
    }
}