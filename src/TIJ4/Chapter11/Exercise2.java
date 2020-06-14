package TIJ4.Chapter11;
/*
* PAGE-220
* 修改SimpleCollection.java，使用Set来表示c
* */

import java.util.HashSet;
import java.util.Set;

public class Exercise2 {

    public static void main(String[] args) {
        Set<Integer> c = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            c.add(i);
        }

        for (Integer i:c
             ) {
            System.out.print(i + ",");
        }
    }

}
