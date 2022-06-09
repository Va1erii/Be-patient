// Level Medium
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (i in 0 until numbers.size) {
            for (j in i + 1 until numbers.size) {
                if (numbers[i] + numbers[j] == target) {
                    return intArrayOf(i + 1, j + 1)
                }
            }
        }
        return numbers
    }
}
