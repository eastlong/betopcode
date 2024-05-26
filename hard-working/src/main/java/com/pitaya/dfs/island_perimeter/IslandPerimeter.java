package com.pitaya.dfs.island_perimeter;

/**
 * @Description: 岛屿的周长
 * @Date 2023/09/24 22:47:00
 **/
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // 陆地才会向上下左右遍历，水域不用遍历,直接跳过
                if (grid[r][c] == 1) {
                    return dfs(grid, r, c);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 从一个岛屿方格走向 非岛屿方格（两种：网格边界、水域方格），周长+1
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 1;
        }
        // 从一个岛屿方格走向水域方格，周长+1
        if (grid[r][c] == 0) {
            return 1;
        }

        if (grid[r][c] != 1) { // （这里只可能是-1了）已经走过的节点会置为-1， 周长不变化
            return 0;
        }

        grid[r][c] = -1; //  // 走到这里，表示的是陆地1，置为-1，陆地实际对周长没影响
        return dfs(grid, r - 1, c) +
                dfs(grid, r+1, c) +
                dfs(grid, r, c - 1) +
                dfs(grid, r, c + 1);
    }

}
