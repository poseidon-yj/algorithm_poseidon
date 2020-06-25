package TIJ4.Chapter11;
/*
* 修改ListFeature.java,让它使用Integer而不是Pet，并解释结果有什么不同*/

import java.util.*;

public class Exercise5 {

    private static final Random RAND = new Random();
    private static final int MAX = 1000;
    public static List<Integer> getIntegerArrayList(int size){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size ; i++) {
            list.add(RAND.nextInt(MAX));
        }
        return list;
    }

    public static Integer random(){
        return RAND.nextInt();
    }

    public static void main(String[] args) {
        List<Integer> IntList = getIntegerArrayList(7);
        System.out.println("1: " + IntList);
        Integer oneInt = random();
        IntList.add(oneInt);
        System.out.println("2: " + IntList);
        System.out.println("3: " + IntList.contains(oneInt));
        IntList.remove(oneInt);
        Integer p = IntList.get(2);
        System.out.println("4: " + p + " index of " + IntList.indexOf(p));
        Integer aNewInt = random();
        System.out.println("5: " + IntList.indexOf(aNewInt));
        System.out.println("6: " + IntList.remove(aNewInt));
        System.out.println("7: " + IntList.remove(p));
        System.out.println("8: " + IntList);
        IntList.add(3, random());
        System.out.println("9: " + IntList);
        List<Integer> sub = IntList.subList(1,4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + IntList.containsAll(sub));
        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);
        System.out.println("11: " + IntList.containsAll(sub));
        Collections.shuffle(sub,RAND);
        System.out.println("shuffleed subList: " + sub);
        System.out.println("12: " + IntList.containsAll(sub));

        List<Integer> copy = new ArrayList<>(IntList);
        sub = Arrays.asList(IntList.get(1), IntList.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(IntList);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        copy.set(1, random());
        System.out.println("16: " + copy);
        copy.addAll(2,sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + copy.isEmpty());
        IntList.clear();
        System.out.println("19: " + IntList);
        System.out.println("20: " + IntList.isEmpty());
        IntList.addAll(getIntegerArrayList(4));
        System.out.println("21: " + IntList);
        Object[] o = IntList.toArray();
        System.out.println("22: " + o[3]);
        Integer[] pa = IntList.toArray(new Integer[0]);
        System.out.println("23: " + pa[2]);

    }
}
