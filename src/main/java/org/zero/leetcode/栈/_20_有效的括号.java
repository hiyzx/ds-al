package org.zero.leetcode.栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 水寒
 * @date 2020/5/21
 * @see https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {// 左括号就入栈
                stack.push(c);
            } else { // 右括号
                if (stack.isEmpty()) { // 栈为空,说明没有可匹配的左括号
                    return false;
                }
                if (c != map.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
