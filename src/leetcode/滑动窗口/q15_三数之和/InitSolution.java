package leetcode.滑动窗口.q15_三数之和;

/*
* 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitSolution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);



        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0){
                return result;
            }

            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == 0){
                    /*List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);*/
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    /*left++;*/
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (tmp > 0){
                    right--;
                }else if (tmp < 0){
                    left++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        InitSolution test = new InitSolution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(test.threeSum(nums));
    }
}
