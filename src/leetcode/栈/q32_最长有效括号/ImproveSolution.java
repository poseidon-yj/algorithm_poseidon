package leetcode.栈.q32_最长有效括号;

import java.util.Stack;

/*
* 其实只需要单栈存放索引号即可
* 因为只有一种括号形式*/
public class ImproveSolution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();//遇到'）'时，总是先弹栈，连续的'）'只要保留最后一个索引号即可
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
