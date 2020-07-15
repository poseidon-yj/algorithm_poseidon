package leetcode.排序.q75.颜色分类;
/*
* 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
*/

import java.util.Arrays;

public class InitSolution {
    public void sortColors(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int p, int r){

        if (p >= r) return;

        int q = partition(nums, p, r);
        quickSort(nums, p, q - 1);
        quickSort(nums, q + 1, r);

    }

    private int partition(int[] nums, int p, int r){
        int q = nums[r];
        int i = p;
        for (int j = p; j <= r - 1; j++) {
            if (nums[j] < q){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        InitSolution test = new InitSolution();
        int[] nums = {1,2,5,2,0,1,2};
        test.sortColors(nums);
        int e = test.partition(nums,0,5);
        System.out.println(e);
        System.out.println(Arrays.toString(nums));
    }
}
