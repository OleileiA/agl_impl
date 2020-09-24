package com.company.LC.初级算法.arr;

public class _arr_3_rotate {

    /*
    *   给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
        输入: [-1,-100,3,99] 和 k = 2
        输出: [3,99,-1,-100]
        解释:
        向右旋转 1 步: [99,-1,-100,3]
        向右旋转 2 步: [3,99,-1,-100]

        1. 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
        2. 要求使用空间复杂度为 O(1) 的 原地 算法。
    * */

    // 暴力法
    // 时间复杂度：O(n*k)O(n∗k) 。每个元素都被移动 1 步（O(n)O(n)） k次（O(k)O(k)） 。
    // 空间复杂度：O(1)O(1) 。没有额外空间被使用。
    public void rotate1(int[] nums, int k) {
        int n = 0;
        int len = nums.length;
        k = k % len;
        while (n < k) {
            int temp = nums[len - 1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            n++;
        }
    }

    // 反转法
    // 假设数组为[1, 2, 3, 4, 5, 6, 7], k = 4
    // 1. 现将数组全部翻转[7, 6, 5, 4, 3, 2, 1]
    // 2. 现将前k个元素翻转：[4, 5, 6, 7, 3, 2, 1]
    // 3. 再讲剩下的元素翻转你: [4, 5, 6, 7, 1, 2, 3]

    // 时间复杂度: 数组整体上翻转了2次, O(n)
    // 空间复杂度: 没有使用额外的空间O(1)
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    // 环状替代法
    // 比起暴力法，就是直接走到目标位置的算法，省略中间的移动过程
    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0; // 记录交换的次数，n个人就交换n次

        for (int start = 0; count < len; start++) {
            System.out.println("start {}" + start);
            int cur = start; // 当前准备换座位的元素下标
            int pre = nums[cur]; // 被挑出来准备换位置的元素

            do {
                int next = (cur + k) % len;
                int temp = nums[next]; // 被换座位的人起立，保存在临时变量
                nums[next] = pre; // 换了
                pre = temp;
                cur = next;
                count++;
                System.out.println("start:" + start + "cur:" + cur);
            } while (start != cur);
        }
    }

    public static void main(String[] args) {
        _arr_3_rotate rot = new _arr_3_rotate();
        rot.rotate3(new int[] {1, 2, 3, 4}, 2);
    }
}
