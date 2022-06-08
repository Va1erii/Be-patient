// Level: Easy
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size
        var mid = 0
        while (start < end) {
            mid = start + (end - start) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                start = mid + 1
            } else {
                end = mid
            }
        }
        return end
    }
}
