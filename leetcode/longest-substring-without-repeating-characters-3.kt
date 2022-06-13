// Level: medium
class Solution {
     /*
     * Runtime: 510 ms, faster than 20.80% of Kotlin online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 76.3 MB, less than 11.20% of Kotlin online submissions for Longest Substring Without Repeating Characters.
     * O(n^2)
     */
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        if (s.length == 1) {
            return 1
        }
        var max = 0
        val buff = HashSet<Char>()
        for (i in 0 until s.length - 1) {
            buff.clear()
            buff.add(s[i])
            for (j in i + 1 until s.length) {
                if (buff.contains(s[j])) {
                    if (buff.size > max) max = buff.size
                    break
                }
                buff.add(s[j])
                if (buff.size > max) max = buff.size
            }
        }
        return max
    }

    /*
     * Runtime: 343 ms, faster than 57.12% of Kotlin online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 41.9 MB, less than 36.71% of Kotlin online submissions for Longest Substring Without Repeating
     * O(n)
     */
    fun lengthOfLongestSubstring2(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        val buff = HashSet<Char>()
        var max = 0
        var i = 0
        var j = 0
        while (i < s.length && j < s.length) {
            if (!buff.contains(s[j])) {
                buff.add(s[j])
                j++
                max = Math.max(max, j - i)
            } else {
                buff.remove(s[i])
                i++
            }
        }
        return max
    }
}