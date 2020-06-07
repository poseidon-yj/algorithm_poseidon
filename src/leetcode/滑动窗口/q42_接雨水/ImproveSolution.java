package leetcode.滑动窗口.q42_接雨水;

/*
* 左右指针向中间逐步逼近，移动左右指针的判断条件在于哪个小，因为大的那一侧可以保证小的那一侧在移动过程中累计的水不会无效*/

public class ImproveSolution {
    public int trap(int[] height){
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0,right_max = 0;

        while (left < right){
            if (height[left] < height[right]){
                if (height[left] < left_max){
                    ans += left_max - height[left];
                }
                else {
                    left_max = height[left];
                }
                left++;
            }
            else {
                if (height[right] < right_max){
                    ans += right_max - height[right];
                }
                else {
                    right_max = height[right];
                }
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        InitSolution test = new InitSolution();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(test.trap(height));
    }

}
