package TIJ4.Chapter11;
/*
* 修改Innerclasses/Sequence.java,使得在Sequence中使用Iterator替代Selector*/

import java.util.ArrayList;
import java.util.Iterator;

/*interface Selector_9{
    boolean end();
    Object current();
    //void next();
}*/

public class Exercise9 {
    private ArrayList<Object> items = new ArrayList<>();
    //public Exercise9(int size) { items = new ArrayList<>(size);}

    public void add(Object x){
            items.add(x);
    }

    /*private class SequenceSelector implements Selector_9 {
        private Iterator<Object> next = items.iterator();
        public boolean end() { return !next.hasNext(); }
        public Object current() {
            return  next.next();
        }
        //public
    }*/

    public Iterator iterator() {
        return items.iterator();
    }

    public static void main(String[] args) {
        Exercise9 sequence = new Exercise9();

        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Iterator selector = sequence.iterator();
        while (selector.hasNext()){
            System.out.println(selector.next());
        }
    }
}
