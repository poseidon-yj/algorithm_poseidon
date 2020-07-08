package TIJ4.Chapter11;
/*使用HashSet和LinkedHashSet重复前一个练习*/

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Exercise19 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        hashSet.add("four");
        hashSet.add("five");

        System.out.println(hashSet);

        TreeSet<String> treeSet = new TreeSet<>(hashSet);
        LinkedHashSet<String> linkedHashSet  = new LinkedHashSet<>();

        for (String s: treeSet){
            linkedHashSet.add(s);
        }
        System.out.println(linkedHashSet);
    }
}
