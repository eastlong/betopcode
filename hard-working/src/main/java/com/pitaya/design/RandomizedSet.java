package com.pitaya.design;

import java.util.*;

/**
 * @Description: 插入、删除、随机访问都是O(1)的容器
 * @Date 2024/05/14 10:17:00
 **/
public class RandomizedSet {

    Map<Integer,Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, list.size()); // map：(val, index)
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        // step1: 找到最后一个元素
        int lastEle = list.get(list.size() - 1);
        int idx = map.get(lastEle);

        // step2: 覆盖待删除的元素
        list.set(idx, lastEle);
        map.put(lastEle, idx);

        // step3: 把list最后一个元素删除
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
