package TIJ4.Chapter11;

import java.util.ArrayList;

/*
* PAGE-218
* 创建一个类Gerbil（沙鼠），包含int gerbilNumber，在构造器中初始化它。
* 添加一个方法hop（），用以打印沙鼠的号码以及它正在跳跃的信息，
* 创建一个arraylist，并向其中添加一串Gerbil对象。使用get（）遍历List，并且对每个Gerbil调用hop（）。*/
public class Exercise1 {
    //private static int counter;
    private int gerbilNumber;

    public Exercise1(int i){
        this.gerbilNumber = i;
    }

    public void hop(){
        System.out.println("沙鼠id: " + this.gerbilNumber + "正在跳跃");
    }

    public static void main(String[] args) {
        ArrayList<Exercise1> exercise1s = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            exercise1s.add(new Exercise1(i));
        }

        for (int i = 0; i < 20; i++) {
            exercise1s.get(i).hop();
        }

    }
}
