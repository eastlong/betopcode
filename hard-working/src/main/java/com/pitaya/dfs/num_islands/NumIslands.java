package com.pitaya.dfs.num_islands;

/**
 * @Description: 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * @Date 2023/09/24 16:48:00
 **/
public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 取出所有的陆地
                if (grid[i][j] == '1') { // 等于0的情况直接跳过了,因为是水域
                    dfs (grid, i, j);
                    count ++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        //防止 i 和 j 越界，也就是防止超出岛屿（上下左右）的范围。特别注意当遍历到海洋的时候也退出循环
        if (i<0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;

        //将遍历过的陆地改为海洋，防止重复遍历
        grid[i][j] = '0';
        dfs(grid, i-1, j);// 上
        dfs(grid, i + 1, j); // 下
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        int i = (0 + 6) / 2;
        System.out.println(i);
    }
}
