package TIJ4.Chapter11;
/*
* 创建一个生成器类，它可以在每次调用其next()方法时，产生你由你最喜欢的电影（你可以用Snow White或者Star Wars）的
* 字符构成的名字（作为String对象）。在字符列表中的电影名字用完后，循环到这个字符列表的开始处。使用这个生成器来填充
* 数组、ArrayList、LinkedList、HashSet、LinkedHashSet和TreeSet，然后打印每一个容器。*/

import java.util.*;

public class Exercise4 {

    public static interface Generator<T> {
        public T next();
    }

    public static class GeneratorImpl implements Generator<String> {


        private static final String[] Movies = new String[]{"Snow White", "海王", "肖申克的救赎", "海上钢琴师"};
        private static final int LENGTH = Movies.length;
        /*private static int count = 0;

        private final int id = ++count;*/

        private int cursor = 0;

        public String next() {
            if (cursor == LENGTH){
                cursor = 0;
            }
            return Movies[cursor++];
        }
    }

    public static Generator<String> getMovieGenerator() {
        return new GeneratorImpl();
    }

    public static String[] getMovies(String[] array){
        Generator<String> gen = getMovieGenerator();
        for (int i = 0; i < array.length ; i++) {
            array[i] = gen.next();
        }
        return array;
    }

    public static Collection<String> getMovies(Collection<String> c, int movieNum) {
        Generator<String> gen = getMovieGenerator();
        for (int i = 0; i < movieNum; i++) {
            c.add(gen.next());
        }
        return c;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public static void main(String[] args) {
        int size = 10;
        System.out.println("Array:>>>");
        System.out.println(Arrays.toString(getMovies(new String[size])));
        System.out.println("ArrayList:>>>");
        System.out.println(getMovies(new ArrayList<>(),size));
        System.out.println("LinkedList:>>>");
        System.out.println(getMovies(new LinkedList<>(),size));
        System.out.println("HashSet:>>>");
        System.out.println(getMovies(new HashSet<>(),size));
        System.out.println("LikedHashSet:>>>");
        System.out.println(getMovies(new LinkedHashSet<>(),size));
        System.out.println("TreeSet:>>>");
        System.out.println(getMovies(new TreeSet<>(),size));
    }
}
