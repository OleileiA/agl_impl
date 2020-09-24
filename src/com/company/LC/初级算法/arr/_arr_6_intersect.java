package com.company.LC.初级算法.arr;


import java.util.Arrays;
import java.util.HashMap;

/*
* 给定两个数组，编写一个函数来计算它们的交集。
*
说明：
输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。


进阶：
如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
* */
public class _arr_6_intersect {

    // 利用hash表
    public int[] intersect(int[] nums1, int[] nums2) {
        // 小的在前面
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 做好map
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count);
        }
        // 新数组
        int[] intersectArr = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersectArr[index++] = num;
                count--;
                if (count > 0) map.put(num, count);
                else map.remove(num);
            }
        }
        return Arrays.copyOfRange(intersectArr, 0, index);
    }


    // 利用有序的数组
    public int[] intersect2(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0;
        int index1 = 0;
        int index2 = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] intersectArr = new int[Math.min(len1, len2)];

        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersectArr[index++] = nums1[index1++];
                index2++;
            }
        }
        return Arrays.copyOfRange(intersectArr, 0 ,index);
    }
}
