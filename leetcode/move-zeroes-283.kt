// Level easy
class Solution {
    fun moveZeroes(nums: IntArray) {
        val copy = IntArray(nums.size) { -666 }
        var k = nums.size - 1
        var j = 0
        for (i in 0 until nums.size) {
            if (nums[i] == 0) {
                copy[k--] = 0
            } else {
                copy[j++] = nums[i]
            }
        }
        for (i in 0 until nums.size) {
            nums[i] = copy[i]
        }
    }
}
