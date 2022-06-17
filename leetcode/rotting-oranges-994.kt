data class Rotten(
    val i: Int,
    val j: Int,
    val t: Int
)

class Solution {
    val rots = LinkedList<Rotten>()
    lateinit var visited: Array<Array<Boolean>>
    var max = 0
    
    fun orangesRotting(grid: Array<IntArray>): Int {
        if(grid.size == 0) return -1
        val rows = grid.size
        val cols = grid[0].size
        visited = Array(rows) { Array<Boolean>(cols) { false } }
        
        for(i in 0 until rows) {
            for(j in 0 until cols) {
                if(grid[i][j] == 2) {
                    rots.add(Rotten(i, j, 0))
                }
            }
        }
        while(rots.size > 0) {
            val rotten = rots.remove()
            val i = rotten.i
            val j = rotten.j
            val t = rotten.t
            
            if(visited[i][j]) {
                continue
            } else {
                grid[i][j] = 0
                visited[i][j] = true
                max = Math.max(max, rotten.t)
                update(i + 1, j, t, grid);
                update(i - 1, j, t, grid);
                update(i, j + 1, t, grid);
                update(i, j - 1, t, grid);
            }
        }
        for(i in 0 until rows) {
            for(j in 0 until cols) {
                if(grid[i][j] == 1) {
                    return -1
                }
            }
        }
        return max
    }
    
    fun update(i: Int, j: Int, t: Int, grid: Array<IntArray>){
        if(i < 0 || j < 0 || i >= visited.size || j >= visited[0].size || visited[i][j] == true || grid[i][j] == 0){
            return
        }
        if(grid[i][j] == 1){
            rots.add(Rotten(i, j, t + 1))
        }
    }
}