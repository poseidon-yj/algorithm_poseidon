package TIJ4.Chapter11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
* 使用Exercise1中的Gerbil类，将其放入Map，将每个Gerbil的名字（例如Fuzzy或者Spot）String（键）与每个Gerbil（值）关联。
* 为KeySet（）获取Iterator，使用它遍历Map，针对每个"键"查询Gerbil，然后打印出"键"，并让gerbil执行hop（）*/
public class Exercise17 {
    public static class Gerbil{
        private static int count = 0;
        private final int id = ++count;
        private String name;
        public Gerbil(String name){
            this.name = name;
        }

        public void hop(){
            System.out.println("沙鼠：#" + id + " " + name + "正在跳跃！");
        }

        public String getName(){
            return name;
        }
    }

    public static void main(String[] args) {
        Map<String, Gerbil> GerbilMap = new HashMap<>();
        Gerbil Fuzzy = new Gerbil("Fuzzy");
        Gerbil Spot = new Gerbil("Spot");
        Gerbil Haha = new Gerbil("Haha");

        GerbilMap.put(Fuzzy.getName(), Fuzzy);
        GerbilMap.put(Spot.getName(), Spot);
        GerbilMap.put(Haha.getName(), Haha);

        Iterator<String> GM_Ite = GerbilMap.keySet().iterator();
        while (GM_Ite.hasNext()){
            String gerbilName = GM_Ite.next();
            System.out.println(gerbilName);
            GerbilMap.get(gerbilName).hop();
        }

        Iterator<Map.Entry<String, Gerbil>> ite = GerbilMap.entrySet().iterator();
        while (ite.hasNext()) {
            Map.Entry<String, Gerbil> entry = ite.next();
            System.out.print("(Gerbil: " + entry.getKey() + ")    >>>     ");
            entry.getValue().hop();
        }

    }
}
