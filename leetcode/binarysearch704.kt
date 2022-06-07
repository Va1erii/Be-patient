// Level: Easy
class BinarySearch704 {
    fun search(nums: IntArray, target: Int): Int {
        return searchIndex(nums, 0, nums.size - 1, target)
    }

    fun searchIndex(nums: IntArray, start: Int, end: Int, target: Int): Int {
        return if (start > end) {
            -1
        } else if (start == end) {
            if (nums[start] == target) start
            else -1
        } else {
            var mid = (start + end) / 2
            if (nums[mid] == target) {
                mid
            } else if (nums[mid] < target) {
                searchIndex(nums, mid + 1, end, target)
            } else {
                searchIndex(nums, start, mid - 1, target)
            }
        }
    }
}
