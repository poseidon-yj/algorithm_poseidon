package leetcode.滑动窗口.q26_删除排序数组中的重复项;

public class InitSolution {
    public int removeDuplicates(int[] nums){
        if (nums.length == 0){
            return  0;
        }
        int left = 0;
        //int right = 1;

        /*while (right < nums.length){
            if (nums[right] == nums[left]){
                right++;
                continue;
            }
            nums[left + 1] = nums[right];
            left++;
            right++;
        }*/

        //代码简洁性
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]){
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        InitSolution test = new InitSolution();
        int[] nums = new int[]{0,0,2,3,3,4};
        System.out.println(test.removeDuplicates(nums));
    }
}
