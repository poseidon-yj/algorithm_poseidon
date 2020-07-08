package TIJ4.Chapter11;

import java.util.LinkedList;
import java.util.ListIterator;

/*
* 创建一个空的LinkedList<Integer>,通过使用ListIterator，将若干个Integer插入这个List中，插入时，总是将他们插入到List的中间*/
public class Exercise14 {
    static void insertMiddle(LinkedList<Integer> list, Integer num){
        int half = list.size() / 2;
        ListIterator<Integer> LIte = list.listIterator(half);
        LIte.add(num);
        System.out.println(list);
    }
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            insertMiddle(ll, i);
        }
    }
}
