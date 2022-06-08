class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size
        while (start < end) {
            val mid = (start + end) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                if (mid > 0 && nums[mid - 1] < target) {
                    return mid
                } else {
                    end = mid - 1
                }
            } else {
                if (mid < nums.size - 1 && nums[mid + 1] > target) {
                    return mid + 1
                } else {
                    start = mid + 1
                }
            }
        }
        return start
    }
}
