package TIJ4.Chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 创建一个类，然后创建一个用你的类的对象进行过初始化的数组。通过使用subList()方法，创建你的List的子集，然后在你的List中移除你的子集*/
public class Exercise7 {
    public static class Table{
        private static int count = 0;
        private final int ID = ++count;
        public String toString(){
            return "TableID: " + ID;
        }
    }

    public static void main(String[] args) {
        int length = 10;
        Table[] ts = new Table[length];
        for (int i = 0; i < length; i++) {
            Table table = new Table();
            ts[i] = table;
        }
        System.out.println("TableList:>>>>>");
        System.out.println(Arrays.toString(ts));
        List<Table> TableList = Arrays.asList(ts);
        List<Table> subList = TableList.subList(0,5);
        System.out.println("SubList:>>>>>");
        System.out.println(subList);
        //TableList.removeAll(subList) 会产生run time ConcurrentModificationException
        List<Table> copy = new ArrayList<>(TableList);
        copy.removeAll(subList);
        TableList = copy;
        System.out.println("TableList:>>>>>");
        System.out.println(TableList);
    }
}
