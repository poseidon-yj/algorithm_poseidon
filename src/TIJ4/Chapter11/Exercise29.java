package TIJ4.Chapter11;

import java.util.PriorityQueue;

/*
* 创建一个继承自Object的简单类，它不包含任何成员，展示你不能将这个类的多个实例成功地添加到一个PriorityQueue中*/
public class Exercise29 {
    static class Simple {

    }

    public static void main(String[] args) {
        PriorityQueue<Simple> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Simple());
        priorityQueue.offer(new Simple());
        priorityQueue.offer(new Simple());

    }
}
