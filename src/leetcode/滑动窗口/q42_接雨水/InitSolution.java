package leetcode.滑动窗口.q42_接雨水;

/*
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
*/

/*
* 难点在于水的流失
* 这里的解是通过先找到数组中的最大值，保证两边向最大值逼近时，累计的水是到最后是不会流失（无效）的*/

public class InitSolution {
    public int trap(int[] height){
        if (height.length <= 1) return 0;

        int tmp = 0;
        int ans = 0;
        //找出数组中最大值的index，然后这根柱子的左边和右边分别计算接水量,需要这个值的原因是因为防止水的流失
        int max = 0;
        int max_index = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i],max);
        }

        for (int i = 0; i < height.length; i++) {
            if (height[i] == max){
                max_index = i;
            }
        }

        //if (max_index == 0) return 0;

        //l1指针从0开始递增，找到第一处l1+1指针小于l1指针的位置（此时才有可能接到雨水）
        int l1;
        for (l1 = 0; l1 < max_index; l1++) {
            if (height[l1 + 1] < height[l1]){
                break;
            }
        }

        int l2 = l1 + 1;

        while (l2 <= max_index){
            if (height[l2] < height[l1]){
                tmp += height[l1] - height[l2];
            }else {
                ans += tmp;
                l1 = l2;
                tmp = 0;
            }
            l2++;
        }

        //r1指针从height-1开始递减，找到第一处r1 - 1指针小于r1的位置
        int r1;
        for (r1 = height.length - 1; r1 > max_index ; r1--) {
            if (height[r1 - 1] < height[r1]){
                break;
            }
        }

        int r2 = r1 - 1;
        tmp = 0;

        while (r2 >= max_index){
            if (height[r2] < height[r1]){
                tmp += height[r1] - height[r2];
            }else {
                ans += tmp;
                r1 = r2;
                tmp = 0;
            }
            r2--;
        }

        return ans;
    }

    public static void main(String[] args) {
        InitSolution test = new InitSolution();
        int[] height = new int[]{1,0,0,1};
        //int[] height = new int[]{0,1,3,2};
        System.out.println(test.trap(height));
    }

}
