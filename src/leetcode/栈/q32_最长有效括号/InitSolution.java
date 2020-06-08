package leetcode.栈.q32_最长有效括号;

import java.util.Stack;

/*
* 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

*/
public class InitSolution {
    public int longestValidParentheses(String s){
        /*
        * 用两个栈，一个栈存放括号，一个存放括号索引，当弹栈时，用当前索引减去索引栈栈顶的元素即为当前最长有效长度*/
        Stack<Character> parentheses = new Stack<>();
        Stack<Integer> index = new Stack<>();
        index.push(-1);//预先放入-1作为栈顶元素
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            //index.push(i);
            if (s.charAt(i) == '('){
                parentheses.push(s.charAt(i));
                index.push(i);
            }
            else {
                if (!parentheses.isEmpty() && parentheses.pop() == '('){
                    index.pop();
                    ans = Math.max(ans,i - index.peek());
                }
                else {
                    index.push(i);
                }
            }
        }

        return ans;
    }
}
