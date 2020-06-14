package TIJ4.Chapter11;
/*
* PAGE-220
* 修改innerclasses/Sequence.java，使你可以向其中添加任意元素*/

import java.util.ArrayList;
import java.util.List;

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Exercise3 {
    private List<Object> items = new ArrayList<>();
    private int next = 0;
    public void add(Object x){
        items.add(x);
    }

    private class SequenceSelector implements Selector {
        private  int i = 0;
        public boolean end(){
            return i == items.size();
        }
        public Object current() {
            return items.get(i);
        }
        public void next(){
            if (i < items.size()) i++;
        }

    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Exercise3 sequence = new Exercise3();

        for (int i = 0; i < 100; i++) {
            sequence.add(i);
        }
        Selector selector = sequence.selector();

        while (!selector.end()){
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
