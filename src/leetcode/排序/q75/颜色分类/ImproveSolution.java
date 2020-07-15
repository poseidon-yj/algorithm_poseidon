package leetcode.排序.q75.颜色分类;

/*
* 关键在于只有3个值，partition函数就可以改进为=0表示已排序区间，=1表示不用交换，=2表示另一个已排序区间
* 这样也无需递归，i指针和r指针相交即可*/

public class ImproveSolution {
    public void sortColors(int[] nums){
        int len = nums.length;
        if (len < 2){
            return;
        }

        int p = 0;
        int r = len - 1;

        int i = 0;
        while (i <= r){
            if (nums[i] == 0){
                swap(nums, i, p);
                p++;
                i++;
            }else if (nums[i] == 1){
                i++;
            }else {
                swap(nums, i, r);
                r--;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
