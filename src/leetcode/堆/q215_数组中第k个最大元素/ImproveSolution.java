package leetcode.堆.q215_数组中第k个最大元素;

import java.util.PriorityQueue;

public class ImproveSolution {
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n1 - n2);

        for (int n : nums){
            heap.add(n);
            if (heap.size() > k){
                heap.poll();
            }
        }

        return heap.poll();
    }
}
