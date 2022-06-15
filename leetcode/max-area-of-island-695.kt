// Level: Medium
class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        var length = 0
        for (i in 0 until grid.size) {
            length = Math.max(length, grid[i].size)
        }
        val areas = Array(grid.size) { IntArray(length) { 0 } }
        for(i in 0 until grid.size) {
            for(j in 0 until grid[i].size) {
                if(areas[i][j] == 0) {
                    max = Math.max(max, findArea(grid, i, j, areas))
                }
            }
        }
        return max
    }
    
    fun findArea(grid: Array<IntArray>, r: Int, l: Int, areas: Array<IntArray>): Int {
        var max = 0
        if(grid[r][l] == 1 && areas[r][l] == 0) {
            max += 1
            areas[r][l] = 1
            if (r < grid.size - 1) max += findArea(grid, r + 1, l, areas)
            if (r > 0) max += findArea(grid, r - 1, l, areas)
            if (l < grid[r].size - 1) max += findArea(grid, r, l + 1, areas)
            if (l > 0) max += findArea(grid, r, l - 1, areas)
        }
        return max
    }
}