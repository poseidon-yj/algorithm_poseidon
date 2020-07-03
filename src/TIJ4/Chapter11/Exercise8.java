package TIJ4.Chapter11;
/*
* 修改Exercise1，以便调用hop()时使用Iterator遍历List*/

import java.util.ArrayList;
import java.util.Iterator;

public class Exercise8 {

    public static void main(String[] args) {
        ArrayList<Exercise1> exercise1s = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            exercise1s.add(new Exercise1(i));
        }
        Iterator<Exercise1> it = exercise1s.iterator();

        while (it.hasNext()){
            it.next().hop();
        }
    }
}
