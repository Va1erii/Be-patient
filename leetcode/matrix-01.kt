class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        if(mat.size == 0) return mat
        val rows = mat.size
        val colums = mat[0].size
        val dist = Array(rows) { IntArray(colums) { 100000000 } }
        for(i in 0 until rows) {
            for(j in 0 until colums) {
                if(mat[i][j] == 0) {
                    dist[i][j] = 0
                } else {
                    if(i > 0) 
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1)
                    if(j > 0) 
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1)
                }
            }
        }
        for(i in rows - 1 downTo 0) {
            for(j in colums - 1 downTo 0) {
                if(i < rows - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1)
                if(j < colums - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1)
            }
        }
        return dist
    }
}