package TIJ4.Chapter11;
/*
* 写一个称为Command的类，它包含一个String域和一个显示该String的operation（）方法。
* 写第二个类，它具有一个使用Command对象来填充一个Queue并返回这个对象的方法。
* 将填充后的Queue传递给第三个类的一个方法，该方法消耗掉Queue中的对象，并调用他们的operation（）方法*/

import java.util.LinkedList;
import java.util.Queue;

public class Exercise27 {
    static  class Command {
        String s;
        Command(String s ){
            this.s = s;
        }

        void operation(){
            System.out.println(s);
        }
    }

    static class Build {
        Queue<Command> make(){
            Queue<Command> q = new LinkedList<>();
            for (int i = 0; i < 10; i++) {
                q.offer(new Command(i + " "));
            }
            return q;
        }
    }

    static class Result {
        static void takeCommand(Queue<Command> q) {
            while (q.peek() != null){
                q.poll().operation();
            }
        }
    }

    public static void main(String[] args) {
        Build build = new Build();
        Queue<Command> q = build.make();
        Result.takeCommand(q);
    }

}
