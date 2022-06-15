// Level: Easy
class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val original = image[sr][sc]
        if(original == newColor) return image
        fill(image, sr, sc, original, newColor)
        return image
    }
    
    fun fill(image: Array<IntArray>, sr: Int, sc: Int, original: Int, newColor: Int) {
        if(image[sr][sc] == original) {
            image[sr][sc] = newColor
            
            if(sr > 0) fill(image, sr - 1, sc, original, newColor)
            if(sr < image.size - 1) fill(image, sr + 1, sc, original, newColor)
            if(sc > 0) fill(image, sr, sc - 1, original, newColor)
            if(sc < image[sr].size - 1) fill(image, sr, sc + 1, original, newColor)
        }
    }
}