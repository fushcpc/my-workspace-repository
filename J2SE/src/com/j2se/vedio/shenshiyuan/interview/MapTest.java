package com.j2se.vedio.shenshiyuan.interview;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * 随机生成50个整数，每个数字的范围是【10，50】
 * 统计每一个数字出现的次数，以及出现次数最多的数字与它的个数，最后将每个数字及其出现次数打印出来，如果某个数字出现次数
 * 为0，则不打印它。打印时按照数字的升序排列。
 * 
 * @author Administrator
 * 
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = getRandom50Integers();

        Collection<Integer> values = map.values();
        int maxOccurs = Collections.max(values);
        Set<Integer> maxVals = new HashSet<Integer>();

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == maxOccurs) {
                maxVals.add(key);
            }
            System.out.println(key + ":" + value);
        }
        System.out.println("最多出现的次数为：" + maxOccurs);
        System.out.println("分别是：");
        for (Integer value : maxVals) {
            System.out.println(value);
        }
    }

    private static Map<Integer, Integer> getRandom50Integers() {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int ranValue = random.nextInt(41) + 10; // 数字的范围是【10，50】
            if (map.containsKey(ranValue)) {
                int oldCount = map.get(ranValue);
                map.put(ranValue, oldCount + 1);
            } else {
                map.put(ranValue, 1);
            }
        }
        return map;
    }
}
