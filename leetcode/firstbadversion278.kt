// Level: Easy
class FirstBadVersion {
    fun firstBadVersion(n: Int): Int {
        var start = 0L
        var end = n.toLong()
        while (start < end) {
            val m = (start + end) / 2
            if (isBadVersion(m.toInt())) {
                end = m
            } else {
                start = m + 1
            }
        }
        return start.toInt()
    }

    fun isBadVersion(version: Int): Boolean {
        return version == 1702766719
    }
}

fun main() {
    println(FirstBadVersion().firstBadVersion(2126753390))
}