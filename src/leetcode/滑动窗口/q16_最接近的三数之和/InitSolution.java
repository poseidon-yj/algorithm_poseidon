package leetcode.滑动窗口.q16_最接近的三数之和;
/*
* 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 

提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
*/

import java.util.*;

public class InitSolution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];


        for (int i = 0; i < len - 2 ; i++) {
            int left = i + 1;//左指针
            int right = len - 1;//右指针

            while (left < right){
                int threeSum = nums[i] + nums[left] + nums[right];

                //这一步是关键，当前的三数之和与taget的差的绝对值越小，就越接近
                if (Math.abs(threeSum - target) < Math.abs(closestSum - target)){
                    closestSum = threeSum;
                }

                if (threeSum > target){
                    right--;
                }else if (threeSum < target){
                    left++;
                }else return threeSum;

            }
        }
        return closestSum;


    }
}
