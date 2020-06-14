package leetcode.堆.q347_前k个高频元素;
/*
* 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 

提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
*/

import com.sun.org.apache.xml.internal.security.Init;

import java.util.*;

public class InitSolution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[k];

        /*
        * key为nums[i],value为nums[i]出现次数*/
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i],0);
            map.put(nums[i],count + 1);
        }
        System.out.println(map);

        /*
        * 小顶堆存放nums[i],排序逻辑是map中value的大小，即nums[i]出现的次数*/
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> map.get(n1) - map .get(n2));

        /*
        * 遍历map，不断地以堆顶元素出现的次数与当前遍历值出现的次数做比较，比堆顶元素大，则堆顶元素弹出，将当前元素塞入堆中*/
        for (Integer i: map.keySet()) {
            if (heap.size() >= k) {

                if (!heap.isEmpty() && map.get(heap.peek()) < map.get(i)){
                    heap.poll();
                }else {
                    continue;
                }
            }

            heap.offer(i);

        }

        while (!heap.isEmpty()){
            ans[k - 1] = heap.poll();
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        InitSolution test = new InitSolution();
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(test.topKFrequent(nums,2)));
    }
}
