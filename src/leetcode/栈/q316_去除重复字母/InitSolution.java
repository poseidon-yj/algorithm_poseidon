package leetcode.栈.q316_去除重复字母;
/*
* 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

 

示例 1:

输入: "bcabc"
输出: "abc"
示例 2:

输入: "cbacdcbc"
输出: "acdb"

*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class InitSolution {
    public String removeDuplicateLetters(String s){
        HashMap<Character,Integer> char_index = new HashMap<>();

        //同时用set和stack存放字符，set用来在O(1)内判断字符是否已存在，stack
        Stack<Character> result = new Stack<>();

        HashSet<Character> seen = new HashSet<>();

        //存放同一字符最大的索引号
        for (int i = 0; i < s.length(); i++) {
            char_index.put(s.charAt(i),i);
        }

        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);

            if (!seen.contains(c)) {
                /*
                 * stack不为空
                 * 当前字符字典序小于栈顶字符
                 * 栈顶字符在string后续还存在
                 * 就弹栈顶元素，同时注意移除set中元素*/
                while (!result.isEmpty() && c < result.peek() && char_index.get(result.peek()) > i) {
                    seen.remove(result.pop());
                }

                seen.add(c);
                System.out.println("当前 : " + i);
                for (Character c1 : seen) {
                    System.out.println(c1);
                }
                result.push(c);
            }
        }

        StringBuilder sb = new StringBuilder(result.size());
        for (Character c : result) sb.append(c.charValue());

        return sb.toString();

    }

    public static void main(String[] args) {
        InitSolution test = new InitSolution();
        String s = "cbacdcbc";
        System.out.println(test.removeDuplicateLetters(s));
    }
}
