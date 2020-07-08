package TIJ4.Chapter11;
/*将以下字符串求值，其中"+"表示将后面的字母压进栈，"-"表示将栈顶字母弹出并打印它
* "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---"*/

import java.util.*;

public class Exercise15 {
    public static void main(String[] args) {
        Stack<Character> sc = new Stack<Character>();
        sc.push('U');
        sc.push('n');
        sc.push('c');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        sc.push('e');
        sc.push('r');
        sc.push('t');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        sc.push('a');
        sc.push('i');
        sc.push('n');
        sc.push('t');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        sc.push(' ');
        System.out.print(sc.pop());
        sc.push('r');
        sc.push('u');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        sc.push('l');
        sc.push('e');
        sc.push('s');
        System.out.print(sc.pop());
        System.out.print(sc.pop());
        System.out.print(sc.pop());
    }
}
