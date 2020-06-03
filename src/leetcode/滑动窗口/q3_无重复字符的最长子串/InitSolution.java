package leetcode.滑动窗口.q3_无重复字符的最长子串;
/*
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/

import java.util.HashSet;

public class InitSolution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> hs = new HashSet<>();
        int result = 0;
        int start = 0;

        while (start < s.length()) {

            int size = 0;
            hs.clear();
            for (int i = start; i < s.length(); i++) {
                if (hs.contains(s.charAt(i))) {
                    break;
                }
                hs.add(s.charAt(i));
                size++;
            }
            start++;
            //result = result > size ? result:size;
            result = Math.max(result,size);
        }

        return result;
    }

    public static void main(String[] args) {
        InitSolution test = new InitSolution();
        System.out.println(test.lengthOfLongestSubstring("bbbb"));
    }
}
