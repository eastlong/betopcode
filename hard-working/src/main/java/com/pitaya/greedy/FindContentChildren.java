package com.pitaya.greedy;

import java.util.Arrays;

/**
 * 分发饼干
 */
public class FindContentChildren {
    /**
     *
     * @param g 胃口
     * @param s 饼干尺寸
     * @return 满足孩子的数量
     * 这里的局部最优就是大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个，全局最优就是喂饱尽可能多的小孩。
     * 思路1：优先考虑饼干，小饼干先喂饱小胃口
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0; // 满足孩子的胃口索引，这里最后用这个字段表示最终满足孩子的数量
        // 遍历饼干
        // i是第i块饼干，index表示第index个小孩的胃
        for (int i=0; i<s.length; i++) {
            if (index <g.length && g[index] <= s[i]) { // 饼干尺寸 >= 孩子的胃口
                index ++; // 满足一个孩子，指向下一个孩子
            }
        }

        return index;
    }
}

/**
 *
 */
