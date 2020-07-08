package TIJ4.Chapter11;
/*
* 写一个方法使用Iterator遍历Collection，并打印容器中每个对象的toString()，
* 填充各种类型的Collection，然后对其使用此方法*/

import java.util.*;

public class Exercise11 {
    public static void printAny(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>(Arrays.asList(11,22,33));
        List<Float> b1 = new LinkedList<>(Arrays.asList(1.1f, 2.2f, 3.3f));
        Set<Character> c1 = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        Set<Double> d1 = new TreeSet<>(Arrays.asList(11.1, 22.2, 3.33));
        Set<String> e1 = new LinkedHashSet<>(Arrays.asList("asd", "desf", "sadasf"));
        printAny(a1);
        printAny(b1);
        printAny(c1);
        printAny(d1);
        printAny(e1);
    }
}
