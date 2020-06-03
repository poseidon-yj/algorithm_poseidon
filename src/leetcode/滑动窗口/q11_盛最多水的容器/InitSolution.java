package leetcode.滑动窗口.q11_盛最多水的容器;
/*
* 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
* 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
* 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
* */

public class InitSolution {
    public int maxArea(int[] height) {
        /*
        * 双指针移动：
        * 左指针left位于height最左侧，右指针right位于height最右侧，并记录此时的容量result
        * 关键点在于指针移动的条件
        * 因为容量size = Math.min(height[left],height[right]) * (right - left)，同时指针一旦移动(right - left)这个值会变小，所以要移动左右指针中小的那一个指针才有可能让result变大
        * */
        int left = 0;
        int right = height.length - 1;
        int result = Math.min(height[left],height[right]) * (right - left);

        while (left != right){
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
            int size = Math.min(height[left],height[right]) * (right - left);
            result = Math.max(size,result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{2,3,4,5,18,17,6};
        InitSolution test = new InitSolution();
        System.out.println(test.maxArea(height));
    }
}
