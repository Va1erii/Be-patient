// Level; Easy
class Solution {
    fun reverseWords(s: String): String {
        var l = 0
        val array = s.toCharArray()
        for (i in 0 until s.length) {
            if (s[i] == ' ') {
                reverse(array, l, i - 1)
                l = i + 1
            }
            if (i == s.length - 1) {
                reverse(array, l, i)
            }
        }
        return String(array)
    }

    fun reverse(s: CharArray, l: Int, r: Int) {
        var left = l
        var right = r
        while (left < right) {
            val temp = s[left]
            s[left++] = s[right]
            s[right--] = temp
        }
    }
}
