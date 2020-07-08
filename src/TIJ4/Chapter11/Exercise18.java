package TIJ4.Chapter11;
/*
* 用键值对填充一个hashmap。打印结果，通过散列码展示其排序。抽取这些键值对，按照键进行排序。
* 并将结果置于一个LinkedHashMap中。展示其维护的插入顺序*/

import java.util.*;

public class Exercise18 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("four", 4);
        hashMap.put("five", 5);
        System.out.println(hashMap);

        Set<String> keySet = new TreeSet<>(hashMap.keySet());
        System.out.println(keySet);

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        for (String s: keySet){
            linkedHashMap.put(s,hashMap.get(s));
        }

        System.out.println(linkedHashMap);

    }
}
