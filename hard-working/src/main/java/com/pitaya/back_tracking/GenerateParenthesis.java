package com.pitaya.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 22. 括号生成
 * @Date 2024/06/04 22:19:00
 **/
public class GenerateParenthesis {
    StringBuffer path = new StringBuffer();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n);
        return res;
    }

    void backtracking(int l, int r, int n) {
        if (l > n || l < r) { // 剪枝
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path.toString());
        }
        for (int i = 0; i < 2; i++) { // 将括号看作大小为 2 的数组，求他们的有效组合，括号个数决定了树的深度
            if (i == 0) {
                path.append("(");
                backtracking(l + 1, r, n);
                path.deleteCharAt(path.length() - 1); // 回溯
            }
            if (i == 1) {
                path.append(")");
                backtracking(l, r + 1, n);
                path.deleteCharAt(path.length() - 1); // 回溯
            }
        }
    }
}

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 */
