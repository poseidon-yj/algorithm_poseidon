package TIJ4.Chapter11;

import java.util.*;

/*
 * 修改ListFeature.java,让它使用String而不是Pet，并解释结果有什么不同*/
public class Exercise6 {
  public static interface Generator<T> {
      public T next();
      public List<T> createList(int listSize);
  }

  public static class Generatorimpl implements Generator<String>{
      private static final Random RAND = new Random();
      private int length = 10;

      public Generatorimpl(){}

      public Generatorimpl(int len){
          length = len;
      }

      public String next(){
          char[] result = new char[length];
          for (int i = 0; i < length; i++) {
              char letter = (char)((int)'a' + RAND.nextInt(26));
              result[i] = letter;
          }
          return new String(result);
      }

      public List<String> createList(int listSize){
          List<String> list = new ArrayList<>();
          for (int i = 0; i < listSize; i++) {
              list.add(next());
          }
          return list;
      }
  }

    public static void testUnitNext(int length) {
        Generatorimpl gen = new Generatorimpl(length);
        System.out.println(gen.next());
    }
    public static void testUnitCreatList(int listSize) {
        Generatorimpl gen = new Generatorimpl();
        System.out.println(gen.createList(listSize));
    }
    public static void main(String[] args) {
        Generatorimpl gen = new Generatorimpl();

        List<String> StrList = gen.createList(7);
        System.out.println("1:" + StrList);

        String s = gen.next();
        StrList.add(s);
        System.out.println("2:" + StrList);
        System.out.println("3:" + StrList.contains(s));
        StrList.remove(s);
        String str = StrList.get(2);
        System.out.println("4:" + str + " " + StrList.indexOf(str));
        String str2 = gen.next();
        System.out.println("5:" + StrList.indexOf(str2));
        System.out.println("6:" + StrList.remove(str2));
        System.out.println("7:" + StrList.remove(str));
        System.out.println("8:" + StrList);
        StrList.add(3, gen.next());
        System.out.println("9:" + StrList);
        List<String> sub = StrList.subList(1, 4);
        System.out.println("sublist: " + sub);
        System.out.println("10:" + StrList.containsAll(sub));
        Collections.sort(sub);
        System.out.println("sorted sublist: " + sub);
        System.out.println("11:" + StrList.containsAll(sub));
        Collections.shuffle(sub,new Random());
        System.out.println("shuffled subList:" + sub);
        System.out.println("12:" + StrList.containsAll(sub));
        List<String> copy = new ArrayList<>(StrList);
        sub = Arrays.asList(StrList.get(1), StrList.get(4));
        System.out.println("sub:" + sub);
        copy.retainAll(sub);
        System.out.println("13:" + copy);
        copy = new ArrayList<>(StrList);
        copy.remove(2);
        System.out.println("14:" + copy);
        copy.removeAll(sub);
        System.out.println("15:" + copy);
        copy.set(1, gen.next());
        System.out.println("16:" + copy);
        copy.addAll(2,sub);
        System.out.println("17:" + copy);
        System.out.println("18:" + StrList.isEmpty());
        StrList.clear();
        System.out.println("19:" + StrList);
        System.out.println("20:" + StrList.isEmpty());
        StrList.addAll(gen.createList(4));
        System.out.println("21:" + StrList);
        Object[] o = StrList.toArray();
        System.out.println("22:" + o[3]);
        String[] sa = StrList.toArray(new String[0]);
        System.out.println("23:" + sa[3]);
    }
}
