package TIJ4.Chapter11;
/*
* 修改第8章中的练习9，使其使用一个Arraylist来存放Rodents，并使用Iterator来访问Rodent序列*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise10 {
    public static interface Rodent {
        public void hop();
    }
    public static class Mouse implements Rodent {
        private static String NAME = "Mouse";
        private static int count = 0;
        private int ID = ++count;
        public void hop() {
            System.out.println(NAME + "#" + ID + " is hopping!");
        }
    }
    public static class Gerbil implements Rodent {
        private static String NAME = "Gerbil";
        private static int count = 0;
        private int ID = ++count;
        public void hop() {
            System.out.println(NAME + "#" + ID + " is hopping!");
        }
    }
    public static class Hamster implements Rodent {
        private static String NAME = "Hamster";
        private static int count = 0;
        private int ID = ++count;
        public void hop() {
            System.out.println(NAME + "#" + ID + " is hopping!");
        }
    }

    public static void main(String[] args) {
        List<Rodent> rodents = new ArrayList<>();
        int rodentsNum = 10;
        for (int i = 0; i < rodentsNum; i++) {
            rodents.add(new Mouse());
            rodents.add(new Gerbil());
            rodents.add(new Hamster());
        }
        Iterator<Rodent> IteRodent = rodents.iterator();
        while (IteRodent.hasNext()){
            IteRodent.next().hop();
        }

    }
}
