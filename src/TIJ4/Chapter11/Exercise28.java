package TIJ4.Chapter11;
/*
* 用java.util.Random创建的Double值填充一个PriorityQueue（用offer方法），然后用poll移除并显示他们*/

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class Exercise28 {
    private Random rand ;
    private PriorityQueue<Double> pd;

    public static void main(String[] args) {
        PriorityQueue<Double> pd = new PriorityQueue<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            pd.offer(rand.nextDouble());
        }

        while (pd.peek() != null){
            System.out.println(pd.poll());
        }
    }
}
