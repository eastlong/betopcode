package com.pitaya;

import java.util.*;

/**
 * @Description: 380
 *  O(1) 时间插入、删除和获取随机元素
 *
 *  变长数组 + 哈希表
 * @Date 2023/09/16 16:17:00
 **/
public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;

    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        int idx = list.size(); // 当前元素的index
        list.add(val);
        map.put(val, idx);

        return true;
    }

    /**
     * 删除元素
     * 思路：把最后一个元素覆盖到待删除的元素中
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val);
        int last = list.get(list.size() - 1);

        list.set(idx, last); // 用最后一个元素覆盖待删除元素
        map.put(last, idx); // 同时更新last元素的索引

        list.remove(list.size() - 1); // list移除最后一个元素
        map.remove(val); // map移除val

        return true;
    }

    /**
     * 随机获取元素
     * @return
     */
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
