package TIJ4.Chapter11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
* 创建2个List<Integer>,先填充第一个List，并使用ListIterator读取第一个List中的元素，然后再将他们以反序插入到第二个列表中*/
public class Exercise12 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            l1.add(i);
        }
        
        List<Integer> l2 = new ArrayList<>();

        ListIterator<Integer> lt1 = l1.listIterator();
        /*while (listIterator.hasNext()){
            l2.addFirst((Integer)listIterator.next());
        }

        for (Integer i: l2){
            System.out.println(i);
        }*/

        ListIterator<Integer> lt2 = l2.listIterator();
        while (lt1.hasNext()){
            lt2.add(lt1.next());
            lt2.previous();
        }
        for (Integer i: l2){
            System.out.println(i);
        }
    }
}
